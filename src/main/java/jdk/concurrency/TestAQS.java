package jdk.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wjf
 * @version 1.0
 * @date 2020/12/15 18:50
 * @desc
 */
public class TestAQS {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        try {
            System.out.println("begin wait");
            condition.await();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
