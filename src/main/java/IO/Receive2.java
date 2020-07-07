package IO;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/25
 */
public class Receive2  extends Thread{
    private PipedInputStream in = new PipedInputStream();
    public PipedInputStream getInputStream() {
        return in;
    }

    @Override
    public void run() {
        readMessageContinued();
    }
    /**
     * 从“管道输入流”读取 > 1024 个字节时，就停止读取
     */
    public void readMessageContinued() {
        int total = 0;
        while (true) {
            byte[] buf = new byte[1024];

            try {
                int len = in.read(buf);
                total += len;
                //System.out.println(new String(buf,0,len));
                System.out.println("第二阶段收到数据");
                //若读取的字节总数 > 1024 则退出循环
                if(total > 1024) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
