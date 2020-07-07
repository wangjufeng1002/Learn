package jvm.demo03_class_load;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/22
 */
public class SuperClass {
    /**
     * 被动使用类字段演示一：
     * 通过子类引用父类的静态字段，不会导致子类初始化
     */
    static {
        System.out.println("SuperClass init!");
    }
    public static  int value = 123;
}
