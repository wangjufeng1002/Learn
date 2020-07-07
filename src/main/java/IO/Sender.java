package IO;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/25
 */
public class Sender extends Thread {
    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOutputStream() {
        return out;
    }

    @Override
    public void run() {
        writeLongMessage();
    }

    // 向“管道输出流”中写入一则较简短的消息："this is a short message"
    private void writeShortMessage() {
        String strInfo = "this is a short message";
        try {
            out.write(strInfo.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 向“管道输出流”中写入一则较长的消息
    private void writeLongMessage() {
        StringBuilder sb = new StringBuilder();
        // 通过for循环写入1020个字节
        for (int i = 0; i < 102; i++) {
            sb.append("0123456789");
        }
        // 再写入26个字节。
        sb.append("abcdefghijklmnopqrstuvwxyz");
        // str的总长度是1020+26=1046个字节
        String str = sb.toString();
        try {
            // 将1046个字节写入到“管道输出流”中
            out.write(str.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
