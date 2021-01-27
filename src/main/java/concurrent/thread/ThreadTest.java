package concurrent.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/25
 */
public class ThreadTest  {
    public static void main(String[] args) throws InterruptedException {
     /*   PrintfThread printfThread01= new PrintfThread();

        for(int i = 0; i< 3;i++){
            Thread thread = new Thread(printfThread01, "Thread" + i);
            thread.start();
        }*/
        TestOp testOp = new TestOp();
        for(int i = 0; i< 1000;i++){
            int finalI = i;
            Thread thread = new Thread(()->{
                Integer integer = testOp.get(finalI);
                System.out.println("传入："+ finalI+" 结果："+integer);
            });
            thread.start();
        }
        Thread.sleep(10000);
    }


}
