package jdk.function;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/8/17 17:41
 */
@FunctionalInterface
public interface TestInterface {
  /*  //抽象方法
     void sub();*/


     //静态方法
    static void staticMethod(){
        System.out.println("staticMethod");
    }
    TestInterface DEFAULT = (webApplicationType)->{
        System.out.println(webApplicationType);
        return 1;
    };
    TestInterface DEFAULT_2 = (webApplicationType)->{
        System.out.println(webApplicationType);
        return 2;
    };
    TestInterface DEFAULT_3 = (webApplicationType)->{
        System.out.println(webApplicationType);
        return 3;
    };

    Integer create(String a);

}
