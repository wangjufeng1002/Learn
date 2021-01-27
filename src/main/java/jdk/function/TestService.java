package jdk.function;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/8/17 17:43
 */
public class TestService {

    public int test(TestInterface testInterface,String mess){
        TestInterface.staticMethod();
       return  testInterface.create(mess);
    }

}
