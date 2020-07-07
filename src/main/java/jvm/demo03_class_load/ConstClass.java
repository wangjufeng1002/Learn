package jvm.demo03_class_load;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/22
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init !");
    }
    public static final String HELLOWORLD = "hello world";
    public static  int value = 123;
}
