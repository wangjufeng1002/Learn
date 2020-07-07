package IO;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/25
 */
public class PipedStreamTest {
    public static void main(String[] args) {
        Sender t1 = new Sender();

        Receiver t2 = new Receiver();

        Receive2 receiver2 = new Receive2();

        PipedOutputStream out = t1.getOutputStream();

        PipedInputStream in = t2.getInputStream();

        PipedOutputStream out2 = t2.getOutputStream();

        try {
            //管道连接。下面2句话的本质是一样。
            //out.connect(in);
            in.connect(out);
            receiver2.getInputStream().connect(out2);
            /**
             * Thread类的START方法：
             * 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
             * 结果是两个线程并发地运行；当前线程（从调用返回给 start 方法）和另一个线程（执行其 run 方法）。
             * 多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
             */
            t1.start();
            t2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void  test() throws IOException {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        in.connect(out);
        try {
            out.write("王巨峰".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] buf = new byte[2048];
        int read = in.read(buf);
        int total = 0;
        String s = new String(buf, 0, read);
        System.out.println(s);
    }
}
