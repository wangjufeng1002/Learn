package learn.thread;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/25
 */
public class PrintfThread extends Thread {
    //private String name;
    private Integer index = 0;


    public  PrintfThread() {

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程启动啦");
        synchronized (index){
            String name = Thread.currentThread().getName();
            System.out.println(name+"---正在输出语句");
            index+=10;
            System.out.println("现在index是===="+index);
        }
        String name = Thread.currentThread().getName();
        System.out.println(name+"刚才执行了输出语句");
    }
}
