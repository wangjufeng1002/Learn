package jvm.demo03_class_load;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/22
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
    public static  Integer a = 1;
}
