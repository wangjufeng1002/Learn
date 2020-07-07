package ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/14
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 *
 * abc
 * 123456789
 * 输出
 *
 * abc00000
 * 12345678
 * 90000000
 */
public class SubString8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = 0;
        List<String> list = new ArrayList<String>();
        while(loop < 2){
            String str1 = sc.nextLine();
            Integer str1Len = str1.length();
            int  n = str1Len % 8;
            if(n > 0){
                n = str1Len / 8 + 1;
            }else{
                n = str1Len / 8;
            }
            int i;
            for(i = 1; i < n ;i++){
                list.add(str1.substring((i-1)*8,(i-1)*8+8));
            }
            String temp = str1.substring((i-1)*8,str1Len);
            int length = temp.length();
            for(int a = 0; a < 8 - length; a++ ){
                temp += "0";
            }
            list.add(temp);
            loop ++;
        }
        for(String str : list){
            System.out.println(str);
        }
    }
}
