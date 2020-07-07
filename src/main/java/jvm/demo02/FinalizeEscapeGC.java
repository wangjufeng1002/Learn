package jvm.demo02;

/**
 * 此代码演示了两点：
 * *1.对象可以在被GC时自我拯救。
 * *2.这种自救的机会只有一次，因为一个对象的finalize（）方法最多只会被系统自动调用一次
 * *@author zzm
 *
 * @author wangjufeng1
 * @description
 * @date 2019/4/13
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize method executed !");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象对一次成功成就自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize 方法优先级很低，所以暂停0.5 秒的等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i am dead :( ");
        }
        //下面这段代码与上面的完全相同，但是这次自救却失败了
        //因为 对象 finalize 方法只能调用一次
        SAVE_HOOK = null;
        System.gc();
        //因为finalize 方法优先级很低，所以暂停0.5 秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i am dead :( ");
        }
    }
}

