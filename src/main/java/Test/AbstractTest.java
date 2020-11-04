package Test;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/8/10 10:27
 */
public abstract class AbstractTest {

    public void method_1(){
        method_2();
        System.out.println("method_1");
    }
    public  void method_2(){
        System.out.println("method_2");
    }
}
