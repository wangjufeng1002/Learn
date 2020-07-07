package ac;

import java.util.Scanner;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/14
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 * 详细描述：
 *
 *
 * 函数接口说明：
 *
 * public String getResult(long ulDataInput)
 *
 * 输入参数：
 *
 * long ulDataInput：输入的正整数
 *
 * 返回值：
 *
 * String
 *
 *
 *
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 */
public class NumberConver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new NumberConver().getResult(Long.parseLong(sc.nextLine())));
    }
    public String getResult(long ulDataInput){
        StringBuilder str = new StringBuilder();
        for(int i = 2; i<= ulDataInput ; ){
            if(ulDataInput % i == 0){
                ulDataInput = ulDataInput/i;
                str.append(i).append(" ");
            }else{
                i++;
            }
        }
        return  str.toString();
    }
}
