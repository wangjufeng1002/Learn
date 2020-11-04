package jdk.function;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/8/17 17:44
 */
public class Main {
    public static void main(String[] args) {
        TestService testService = new TestService();
        testService.test(()->{
            System.out.println("11111111111");
        });
    }
}
