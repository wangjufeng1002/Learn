package ac;
import java.util.*;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/14
 */
public class MergeKeyValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int i = 0;
        TreeMap<String,Integer> map = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return  Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        while(i <total){
            String  key = sc.next();
            int value = sc.nextInt();
            Integer value1 = map.get(key);
            if(value1 == null){
                map.put(key,value);
            }else{
                map.put(key,value+value1);
            }
            i++;
        }
        for(String a : map.keySet()){
            System.out.println(a + " " + map.get(a));
        }
    }
    /**
     *  public static void main(String[] args) {
     *         Scanner str = new Scanner(System.in);
     *         SortedMap<Integer,Integer> map = new TreeMap<>();
     *         int n = Integer.parseInt(str.nextLine());
     *         for (int i = 0;i<n;i++){
     *             String[] mid = str.nextLine().split("\\s+");
     *             addPare(map,mid);
     *         }
     *         System.out.println(mapToString(map));
     *     }
     *
     *     private static String mapToString(SortedMap<Integer, Integer> map) {
     *         // TODO Auto-generated method stub
     *         StringBuilder builder = new StringBuilder();
     *         for(SortedMap.Entry<Integer,Integer>e:map.entrySet()){
     *             builder.append(e.getKey()).append(" ").append(e.getValue()).append("\r");
     *         }
     *         return builder.toString();
     *     }
     *
     *     private static void addPare(SortedMap<Integer, Integer> map, String[] mid) {
     *         // TODO Auto-generated method stub
     *         int key = Integer.parseInt(mid[0]);
     *         int value = Integer.parseInt(mid[1]);
     *         if(map.containsKey(key)){
     *             map.put(key, map.get(key) + value);
     *         }else{
     *             map.put(key, value);
     *         }
     *     }
     */
}
