package jvm.demo03_class_load;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/22
 */
public class NotInitializtion {
    public static void main(String[] args) {
        /*
            1. 非主动使用类字段演示
         */
       // System.out.println(SubClass.value);
        /*
            2. 通过数组定义来引用类，不会触发此类的初始化
         */
        //SuperClass[] superClasses = new SuperClass[10];

        /*
            3.
         */
        System.out.println(ConstClass.HELLOWORLD);
    }
}
