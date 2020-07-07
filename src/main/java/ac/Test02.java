package ac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/23
 */
public class Test02 {

    public static void main(String[] args) {
      /*  int [][] array= new int[3][2];
        System.out.println(array[1].length);*/
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);
        for(int i = list.size()-1 ;i >= 0 ;i--){
            System.out.println(list.get(i));
        }*/
        Stack stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.clear();
        stack.push(4);

       /* for (Object aStack : stack) {
            System.out.println(aStack);
        }*/
    }

    /*public boolean Find(int target, int [][] array) {

    }*/

}
