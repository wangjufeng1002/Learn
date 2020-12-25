package concurrent.lock.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author wjf
 * @version 1.0
 * @date 2020/12/25 19:37
 * @desc
 */
public class Point {
    //成员变量
    private double x,y;
    //锁实例
    private final StampedLock s1 = new StampedLock();

    void move(double deltaX,double deltaY){
        long stamp = s1.writeLock();
        try {
            x+=deltaX;
            y+=deltaY;
        } finally {
            s1.unlockRead(stamp);
        }
    }

    //乐观读锁
    double distanceFromOrigin(){
        //（1） 尝试获取乐观读锁
        long stamp = s1.tryOptimisticRead();
        //（2）将全部变量复制到方法体栈内
        double currentX = x,currentY = y;
        //（3）检查在(1) 处获取读锁戳记后，锁没有被其他线程排它性抢占。
        if(!s1.validate(stamp)){
            // (4) 如果被抢占则获取一个共享读锁（悲观获取）
            stamp = s1.readLock();
            try {
                //(5) 将全部变量复制到方法体栈内
                currentX = x;
                currentY = y;
            } finally {
                //(6) 释放共享锁
                s1.unlockRead(stamp);
            }
        }
        //(7) 返回计算结果
        return Math.sqrt(currentX*currentX + currentY*currentY);
    }

    void moveIfAtOrgin(double newX,double newY){
        //（1） 这里可以使用乐观读锁替换
        long stamp = s1.readLock();
        try{
            //(2) 如果当前点在原点则移动
            while (x==0.0 && y==0.0){
                //(3) 尝试将获取的读锁升级为写锁
                long ws = s1.tryConvertToWriteLock(stamp);
                //(4) 升级成功，则更新戳记，并设置坐标值，然后退出循环
                if(ws != 0L){
                    stamp = ws;
                    x =newX;
                    y =newY;
                    break;
                }else {
                    //(5) 读锁升级写锁失败则释放读锁，显示获取独占写锁，然后循环重试
                    s1.unlockRead(stamp);
                    stamp = s1.writeLock();
                }
            }
        }finally {
            s1.unlockRead(stamp);
        }
    }

}
