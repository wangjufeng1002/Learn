package ac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wangjufeng1
 * @description
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * @date 2019/6/15
 */
public class IntegerConver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strChar = str.toCharArray();
        Set<String> set = new HashSet<>();
        String result = "";
        for(int i = strChar.length -1 ; i >= 0 ; i--){
            String s = String.valueOf(strChar[i]);
            if(!set.contains(s)) {
                set.add(s);
                result += s;
            }
        }
        System.out.println(Integer.parseInt(result));
    }
}
