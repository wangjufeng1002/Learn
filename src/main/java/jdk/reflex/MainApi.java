package jdk.reflex;

import common.CacheKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class MainApi {
  /*  public static void main(String[] args) throws  Exception {
        //通过反射获取方法
        Method declaredMethod = TestObject.class.getDeclaredMethod("print", List.class);
        //获取返回值的类型，此处不是数组
        Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
        for(Type type : genericParameterTypes){
            System.out.println(type.getTypeName());
        }

        for(Type type : genericParameterTypes){
            //只有带泛型的参数才是这种Type，所以得判断一下
            if(type instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) type;
                //获取参数的类型
                System.out.println(parameterizedType.getRawType());
                //获取参数的泛型列表
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for(Type type2 : actualTypeArguments){
                    if(type2.getTypeName().equals(String.class.getTypeName())){
                        System.out.println(type2.getTypeName());
                    }

                }
            }
        }
    }*/

    public static void main(String[] args) throws Exception {
        TestObject02 testObject02 = new TestObject02();
        testObject02.setKey("aaaaa");
        testObject02.setValue("dadsdasdasdasdasdas");

        TestObject02 testObject021 = new TestObject02();
        testObject021.setKey("bbbbbbbbbbbb");
        testObject021.setValue("dsadsdasd");
        Object obj = (Object) testObject02;
        List<TestObject02> list = new ArrayList<TestObject02>();
        list.add(testObject02);
        list.add(testObject021);
        Object objList = list;
        Field field = null;
        if (objList instanceof List) {
            List castList = List.class.cast(objList);
            for (Object objL : castList) {
                if (field == null) {
                    Field[] declaredFields = obj.getClass().getDeclaredFields();
                    for (Field fieldTemp : declaredFields) {
                        if (fieldTemp.getAnnotation(CacheKey.class) != null && fieldTemp.getType().equals(String.class)) {
                            fieldTemp.setAccessible(true);
                            field = fieldTemp;
                        }

                    }

                }
                System.out.println(field.get(objL));
            }
       /* Class<?> objClass = obj.getClass();
        Method[] declaredMethods = objClass.getDeclaredMethods();
        System.out.println(declaredMethods.length);
        Field[] fields = objClass.getDeclaredFields();
        System.out.println(fields.length);
        for(Field field :fields){
            if(field.getAnnotation(CacheKey.class) != null && field.getType().equals(String.class)){
                field.setAccessible(true);
                System.out.println(field.get(obj));
            }
        }*/
        }
    }
}
