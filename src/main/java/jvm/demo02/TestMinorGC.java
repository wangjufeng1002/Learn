package jvm.demo02;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/18
 */
public class TestMinorGC {
    private static final int _1MB = 1024 * 1024;
    private static final int _1_2MB = 1024 * 512;


    public static void main(String[] args) {
        // testPertenureSizeThreshold();
       // testTenuringThreshold();
       // testTenuringThreshold02();
       // testHandlePromotion02();
       // testHandlePromotion();
    }

    public static void testAllocation() {
        /*
         * /**
         * *VM参数：-verbose：gc-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails -XX：SurvivorRatio=8
         * -Xloggc:E:/dump/gc.log 输出 gc 日志
         */
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //出现一次 Minor GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void testPertenureSizeThreshold() {
        /*
            -verbose:gc
            -Xms20M
            -Xmx20M
            -Xmn10M
            -XX:+PrintGCDetails
            -XX:SurvivorRatio=8
            -XX:PretenureSizeThreshold=3145728
         */
        byte[] allocation;
        //直接分配在老年代 -XX:PretenureSizeThreshold
        allocation = new byte[4 * _1MB];
    }

    public static void testTenuringThreshold() {
         /*
            -verbose:gc
            -Xms20M
            -Xmx20M
            -Xmn10M
            -XX:+PrintGCDetails
            -XX:SurvivorRatio=8
            -XX:MaxTenuringThreshold=1
            -XX:+PrintTenuringDistribution
         */
        byte[] allocation1, allocation2, allocation3, allocation4;
       allocation1 = new byte[_1MB / 4];  // 256k
        //什么时候进入老年代取决于 XX:MaxTenuringThreshold 设置
        allocation2 = new byte[4 * _1MB]; //4096K
        //虚拟机执行到此后，需要进行一次GC ，将 eden 中 allocation1 的 移入 Survivor ，allocation2 由于 Survivor 无法存储，直接进入老年代
        allocation3 = new byte[4 * _1MB]; //4096K
        allocation3 = null; //这里如果设置null ，下一行代码执行时 allocation3 之前引用的堆内存就无法被释放，而直接进入老年代
        //虚拟机执行到此后，需要进行第二次GC ，因为 MaxTenuringThreshold 设置为1 ，所以，allocation1 将进入老年代 ，这时老年代中应该是 allocation2 + allocation1 ,allocation3 新建的对象在 eden 中，Survivor被清空为0
       allocation3 = new byte[4 * _1MB];

    }

    /**
     * 动态对象年龄判定
     */
    public static void testTenuringThreshold02() {
         /*
            -verbose:gc
            -Xms20M
            -Xmx20M
            -Xmn10M
            -XX:+PrintGCDetails
            -XX:SurvivorRatio=8
            -XX:MaxTenuringThreshold=15
            -XX:+PrintTenuringDistribution
         */
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];  // 256k
        allocation2 = new byte[_1MB / 4];  // 256k
        // allocation1 + allocation2 大于 survivo 空间一半
        allocation3 = new byte[4 * _1MB]; //4096K
        // jvm 会在此处进行一次 GC 因为 eden 中已经有  (256+256+4096)k 的对象，无法在存储 allocation4 ，
        //       所以会在gc 之后，1. 将 allocation1,allocation2 移入 survivor 中 ，2.  将allocation3 移入 老年代
        allocation4 = new byte[4 * _1MB]; //4096K
        allocation4 = null; //此处，如果不置为 null , gc无法回收，将导致 allocation4 第一次创建的对象 进入老年代
        //在执行下面语句之前，发现 survivor 中的  allocation1,allocation2 的大小，大于 survivor的一半，并且年龄相同，会将  allocation1,allocation2 移入 老年代
        allocation4 = new byte[4 * _1MB]; //4096K
    }

    /**
     * 空间分配担保1
     */
    public static void testHandlePromotion() {
          /*
            -verbose:gc
            -Xms20M
            -Xmx20M
            -Xmn10M
            -XX:+PrintGCDetails
            -XX:SurvivorRatio=8
            -XX:-HandlePromotionFailure
         */
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[_1MB * 2];
        allocation2 = new byte[_1MB * 2];
        allocation3 = new byte[_1MB * 2];
        // 新生代 总共10M  , 上述代码执行完成已经占用 6 M
        allocation1 = null;
        // 在为 allocation4 创建对象时，发现 eden 即将占满，进行一次GC , 这是老年代 可以存储 10M ,所以老年代担任起了担保人，GC 之后，allocation1 之前引用的对象 被回收，而 allocation2、allocation3  进入老年代
        allocation4 = new byte[_1MB * 2];
        allocation5 = new byte[_1MB * 2];
        allocation6 = new byte[_1MB * 2];

        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        //在为 allocation7 创建对象时 , eden中已经含有allocation4，allocation5，allocation6 发现 eden 即将占满，进行一次垃圾回收，这次回收，主要看HandlePromotionFailure 参数，以及老年代剩余的内存大小 、 新生代所有对象大小的
        // allocation7 是 2M ,而老年代中含有 4M 还剩 6M ，但是新生代中也含有 6M，第一次新生代进入老年代是 4M，当前版本是1.7 不考虑HandlePromotionFailure ，直接进行一次 Minor GC
        // 如果 allocation4，allocation5 ，allocation6 是加起来大于 6M
        // 老年代的连续空间大于新生代对象总大小或者历次晋升的平均大小就  会进行Minor GC，否则将进行Full GC。
        allocation7 = new byte[_1MB * 2];
    }

    /**
     * 空间分配担保2
     */
    public static void testHandlePromotion02() {
          /*
            -verbose:gc
            -Xms20M
            -Xmx20M
            -Xmn10M
            -XX:+PrintGCDetails
            -XX:SurvivorRatio=8
            -XX:-HandlePromotionFailure
         */
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[_1MB * 2];
        allocation2 = new byte[_1MB * 2];
        // GC -  因为，jvm初始化 eden 中的 26%空间已经被占用， allocation1,allocation2 >  survivor ，所以进入老年代, 这时 eden 中只有 allocation3
        allocation3 = new byte[ _1MB * 2 + 1024 * 11];
        allocation4  =  new byte[ 1024*2];
        allocation1 = null;
       // allocation4 = new byte[_1MB * 2];

      //  allocation5 = new byte[_1MB * 2];
        //GC -  失败，因为 老年代剩余最多 6M 而，新生代中allocation3,allocation4,allocation5 .一共 7M
        //FullGC  ,老年代中的 allocation1 被清理， allocation2，allocation3，allocation4，allocation5 一共 9M 进入老年代， allocation6 进入新生代
       // allocation6 = new byte[_1MB * 3];

      //  allocation4 = null;
      //  allocation5 = null;
      //  allocation6 = null;
        // 如果 allocation4，allocation5 ，allocation6 是加起来大于 6M
        //老年代的连续空间大于新生代对象总大小或者历次晋升的平均大小就  会进行Minor GC，否则将进行Full GC。
       // allocation7 = new byte[_1MB * 2];


        //当对象大于 eden + survivor(from) 的剩余的 内存空间时，会进行GC
        //当对象小于 eden + survivor(from) 的剩余的 内存空间时 ，不会进行GC
        //这就可以解释 2 2 3 和  3 2 2 的区别
    }

    public TestMinorGC() {
        System.out.println("初始化");
    }
}
