package jdk.concurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * @author wjf
 * @version 1.0
 * @date 2020/12/15 16:54
 * @desc
 */
public class TestLockSupport {
  /*  public static void main(String[] args) {
        System.out.println("begin park!");

        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();
        LockSupport.park();

        System.out.println("end park");
    }*/
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                while (!Thread.currentThread().isInterrupted()) {
                    LockSupport.park();
                }
                System.out.println("child thread upark");
            }
        });
        //启动子线程
        thread.start();
        //主线程休眠
        Thread.sleep(1000);

        System.out.println("main thread begin unpark");

        //中断子线程
        thread.interrupt();
    }
}
