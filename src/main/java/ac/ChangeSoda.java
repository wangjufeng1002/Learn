package ac;

import java.util.Scanner;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/29
 */
public class ChangeSoda {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int i = -1;
        int [] result = new int[10];
        while(++i < 10){
            int n =  sc.nextInt();
            if(n == 0){
                break;
            }
            result[i] = changeDrank(n);
        }
        for(int a = 0 ; a < i; a++ ){
            System.out.println(result[a]);
        }

    }
    public static int changeDrank(int n){
        if(n < 2){
            return 0;
        }
        if(n == 2 || n == 3){
            return 1;
        }
        //换完剩多少个瓶子
        int a = n % 3;
        //换了多少个瓶子
        int b = n / 3;
        //总共剩多少个瓶子
        int total = a + b;
        return b + changeDrank(total);

    }
}
