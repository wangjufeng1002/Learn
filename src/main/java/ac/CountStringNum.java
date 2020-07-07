package ac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/15
 */
public class CountStringNum {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String  str = sc.nextLine();
        Set<Integer> set = new HashSet<>();
        int temp ;
        for(char c : str.toCharArray()){
            temp = (int)c;
            if(temp >=1 && temp <= 127){
                set.add(temp);
            }
        }
        System.out.println(set.size());
    }
}
