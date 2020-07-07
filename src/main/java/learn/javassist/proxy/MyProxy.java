package learn.javassist.proxy;

import javassist.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/23
 */
public class MyProxy {
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler) {
        Class<?> inter = interfaces[0];
        Method[] methods = inter.getDeclaredMethods();
        ClassPool pool = ClassPool.getDefault();

        //生成ProxyClass对象
        CtClass proxy = pool.makeClass("learn.javassist.proxy.ProxyClass");
        try {
            CtClass interfaceCt = pool.get(inter.getName());
            CtClass invocation = pool.get(InvocationHandler.class.getName());
            //动态代理类实现了接口
            proxy.addInterface(interfaceCt);

            //动态代理类包含InvocationHandler的字段h
            CtField h = new CtField(invocation, "h", proxy);
            h.setModifiers(Modifier.PRIVATE);
            proxy.addField(h);

            //动态代理类包含一个InvocationHandler的执行逻辑
            for (Method method : methods) {
                String name = method.getName();
                String retType = method.getReturnType().getName();
                StringBuilder builder = new StringBuilder();
                builder.append("public").append(retType).append(" ").append(name).append("() {");
                builder.append("trt{ ");
                builder.append("java.lang.reflect.Method method = ").append(inter.getName())
                        .append(".class.getDeclaredMethod(\"").append(name).append("\",null);");
                builder.append("h.invoke(this,method,null);");
                builder.append("} catch(Throwable e)");
                builder.append("{ throw new RuntimeException(e); } }");

                System.out.println(builder.toString());
                CtMethod m = CtNewMethod.make(builder.toString(), proxy);
                proxy.addMethod(m);
            }
            //通过反射生成动态代理对象
            Class<?> clazz = proxy.toClass();
            Constructor<?> construct = clazz.getConstructor(InvocationHandler.class);
            return construct.newInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
