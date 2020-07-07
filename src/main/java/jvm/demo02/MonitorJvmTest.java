package jvm.demo02;

import java.util.ArrayList;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/19
 */
public class MonitorJvmTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }
    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<OOMObject>();
        for(int i = 0 ; i< num; i++){
            //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(1000);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        /*
          -Xms100m
          -Xmx100m
          -XX:+UseSerialGC
          -Dcom.sun.management.jmxremote
          -Dcom.sun.management.jmxremote.port=8011
          -Dcom.sun.management.jmxremote.ssl=false
          -Dcom.sun.management.jmxremote.authenticate=false
         */
        fillHeap(50);
    }
}
