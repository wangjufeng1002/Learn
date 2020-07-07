package jvm.demo02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/8
 */
public class RuntimeConstantPoolOOM {
    /*public static void main(String[] args) {
        //使用List保持着常量池引用、避免Full GC 回收常量池行为
        List<String> list = new ArrayList<String>();
        //10 M 的Permsize 在Integer 范围内足够产生OOM 了
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }*/

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

}
