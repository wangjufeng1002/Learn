package proxy.javassist;

import javassist.*;
import javassist.bytecode.ClassFile;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/23
 */
public class ChangeDemo {
    public static void main(String[] args) {


      /* String  newMectodBody="System.out.println(\"this method is chanhed dynameically!\");";
        replaceMethodBody("learn.javassist.Student","execute",newMectodBody);
        Student student = new Student();
        student.execute();
        student.execute();*/

        addClassField("learn.javassist.Student");
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public static void replaceMethodBody(String clazzName, String mecthodName, String newMethodBody) {
        try {
            CtClass clazz = ClassPool.getDefault().get(clazzName);
            CtMethod method = clazz.getDeclaredMethod(mecthodName);
            method.setBody(newMethodBody);
            clazz.toClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addClassField(String classNmae) {
        try {
            CtClass clazz = ClassPool.getDefault().get(classNmae);
            CtClass stringClazz = ClassPool.getDefault().getCtClass("java.lang.String");
            CtField ctField = new CtField(stringClazz, "interest", clazz);
            clazz.addField(ctField);
            clazz.toClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param clazz
     * @param set
     * @throws Exception
     */
    private static void bfs(String clazz, Set<String> set) throws Exception {
        CtClass ctClass = ClassPool.getDefault().get(clazz);
        //当前类依赖的类
        Set<String> levelClasses = new TreeSet<String>();
        ClassFile classFile = ctClass.getClassFile();
        /**
         * 遍历代码内部使用的类，包含方法实现里使用的类，不包含方法签名中的类
         */
        for (String className : classFile.getConstPool().getClassNames()) {
            if (className.startsWith("[L")) {
                className = className.substring(2, className.length() - 1);
            } else if (className.startsWith("[")) {
                continue;
            }
            className = getClassName(className);
            addClassName(set, levelClasses, className);
            //TODO
        }
        /**
         * 获取父类
         */
        String superClass = classFile.getSuperclass();
        if (!"".equals(superClass) && superClass != null && !set.contains(superClass)) {
            levelClasses.add(superClass);
            set.add(superClass);
        }
        /**
         * 获取所有接口
         */
        String[] interfaces = classFile.getInterfaces();
        if (interfaces != null) {
            for (String face : interfaces) {
                String className = getClassName(face);
                addClassName(set, levelClasses, className);
            }
        }
        /**
         * 获取字段类型
         */
        List<FieldInfo> fieldInfoList = classFile.getFields();
        if (fieldInfoList != null) {
            for (FieldInfo fieldInfo : fieldInfoList) {
                String descriptor = fieldInfo.getDescriptor();
                if (descriptor.startsWith("L") && descriptor.endsWith(";")) {
                    String className = descriptor.substring(1, descriptor.length() - 1);
                    className = getClassName(className);
                    addClassName(set, levelClasses, className);
                }
                if (descriptor.startsWith("[L") && descriptor.endsWith(";")) {
                    String className = descriptor.substring(2, descriptor.length() - 1);
                    className = getClassName(className);
                    addClassName(set, levelClasses, className);
                }
            }
        }
        /**
         * 获取方法声明参数和返回值包含的所有类
         */
        List<MethodInfo> methodInfoList = classFile.getMethods();
        if (methodInfoList != null) {
            for (MethodInfo methodInfo : methodInfoList) {
                String desciptor = methodInfo.getDescriptor();
                extractClassNames(desciptor, set, levelClasses);
            }
        }

        /**
         * 对当前类直接依赖的类
         */
        if (!levelClasses.isEmpty()) {
            for (String className : levelClasses) {
                bfs(className, set);
            }
        }
    }

    private static void addClassName(Set<String> set, Set<String> levelClasses, String className) {
        //如果当前节点已经被访问过，不再将它添加到当前类的直接依赖中
        if (!set.contains(className)) {
            levelClasses.add(className);
            set.add(className);
        }
    }


    private static String getClassName(String className) {
        return className.replaceAll("/", ".");
    }

    private static void extractClassNames(String descriptor, Set<String> set, Set<String> levelClasses) {
        String reg = "(L.+?;)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(descriptor);
        while (matcher.find()) {
            String className = matcher.group();
            className = className.substring(1, className.length() - 1);
            className = getClassName(className);

        }
    }

}
