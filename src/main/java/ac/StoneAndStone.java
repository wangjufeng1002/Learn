package ac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/5/15
 */
public class StoneAndStone {
    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头            中有多少是宝石。
     *
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *
     * 示例 1:
     *
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     * 示例 2:
     *
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     * 注意:
     *  "aA"
     * "aAAbbbb"
     * S 和 J 最多含有50个字母。
     *  J 中的字符不重复。
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String J = scan.nextLine();
        String S = scan.nextLine();

        char[] chars = J.toCharArray();
        char[] chars2 = S.toCharArray();
        Map<String,Integer> map = new HashMap();
        Integer a ;
        for (char c : chars2){
            a = map.get(String.valueOf(c));
            if(a != null && a.intValue() >= 1 ){
                a++;
            }else{
                a = 1 ;
            }
            map.put(String.valueOf(c),a);
        }
        Integer num = 0;
        for (char c : chars) {
            Integer b = map.get(String.valueOf(c));
            if(b != null){
                num +=b;
            }
        }
        System.out.println(num);
    }

}
