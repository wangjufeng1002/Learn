package jdk.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wjf
 * @version 1.0
 * @date 2021/1/14 13:48
 * @desc
 */
public class TestConcurrentHashMap {
    public static void main(String[] args) {
     /*   ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>(2);
        concurrentHashMap.put(1,1);
        concurrentHashMap.put(2,1);
        concurrentHashMap.put(3,1);*/
        HashMap<Integer, Integer> objectObjectHashMap = new HashMap<>(10);
        objectObjectHashMap.put(1,1);
        objectObjectHashMap.put(2,2);
        objectObjectHashMap.put(3,3);
        System.out.println(objectObjectHashMap.size());
        //System.out.println(concurrentHashMap.size());
    }
}

