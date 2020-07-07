package jvm.demo02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/8
 */
public class HeapOOM {

    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
