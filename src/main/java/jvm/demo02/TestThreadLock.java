package jvm.demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/19
 */
public class TestThreadLock {
    /**
     * 线程死锁演示
     */
    @SuppressWarnings(value={"unchecked", "rawtypes"})
    public static void createBusyThread(){
        @SuppressWarnings("rawtypes")
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                }
            }
        },"testBusyThread");
        thread.start();
    }

    public static void createLockThread(final  Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }
    private void testThread(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader.readLine();
            createBusyThread();
            bufferedReader.readLine();
            Object o = new Object();
            createLockThread(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static class SynAddRunalbe implements Runnable{
        int a,b;
        public  SynAddRunalbe(int a ,int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }

    public static void testLock2(){
        for(int i = 0 ; i <200; i++){
            new Thread(new SynAddRunalbe(1,2)).start();
            new Thread(new SynAddRunalbe(2,1)).start();
        }
    }
    public static void main(String[] args) {
        testLock2();
    }
}
