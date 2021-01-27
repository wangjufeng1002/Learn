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
        System.out.println(testService.test(TestInterface.DEFAULT_2,"传入参数！！！"));

        MergeEnum.AA.getiTestMergeService().a(1);
    }
}
