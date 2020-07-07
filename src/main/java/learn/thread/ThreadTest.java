package learn.thread;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/25
 */
public class ThreadTest  {
    public static void main(String[] args) {
        PrintfThread printfThread01= new PrintfThread();

        for(int i = 0; i< 3;i++){
            Thread thread = new Thread(printfThread01, "Thread" + i);
            thread.start();
        }

    }
}
