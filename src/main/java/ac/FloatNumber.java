package ac;

import java.util.Scanner;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/14
 */
public class FloatNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.nextLine();
        String strValue = str.split("\\.")[1];
         Integer value = Integer.valueOf(strValue);
        if(String.valueOf(value + 5).length() > strValue.length()){
            System.out.println(Integer.parseInt(str.split("\\.")[0])+1);
        }else {
            System.out.println(Integer.parseInt(str.split("\\.")[0]));
        }

    }
}
