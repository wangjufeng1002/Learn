package ac;

import java.util.*;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/6/15
 *
 * 接口说明
 *
 * /**
 *  * 反转句子
 *  *
 *  * @param sentence 原句子
 *  * @return 反转后的句子
 *  public String reverse(String sentence);
 *
 */
public class Test {
    public static int [][] a = new int[4][3];


  /*  public static void main(String [] args){
       *//* Scanner sc = new Scanner(System.in);
        int num=sc.hasNextLine()?Integer.parseInt(sc.nextLine()):0;
        TreeSet<String> set = new TreeSet<>();
        while(--num >= 0 && sc.hasNextLine()){
            set.add(sc.nextLine());
        }
        for(String s : set){
            System.out.println(s);
        }*//*

     *//*   Scanner sc = new Scanner(System.in);
        int num=sc.hasNextLine()?Integer.parseInt(sc.nextLine()):0;
        String str = Integer.toBinaryString(num);
        int n = 0;
        for(int i =0;i<=str.length()-1;i++){
            if('1' == str.charAt(i)){
                n++;
            }
        }
        System.out.print(n);*//*
        *//*a[0][1] =1;
        a[0][1] =1;
        a[0][1] =1;*//*
        System.out.println(a.length);

    }*/
 /* public static void main(String [] args){
      Scanner sc =  new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();
      if(a == b){
          System.out.println(a);
          return;
      }
      int max ,min ;
      if(a > b){
          max = a;
          min = b;
      }else{
          max = b;
          min = a;
      }
      int temp = max % min;
      if(temp == 0){
          System.out.println(max);
          return;
      }
      while(temp != 0){
          max =  min % temp ;
          min = temp;
          temp = max;
      }
      System.out.println((a*b)/min);

  }*/
  public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      String [] arr = sc.nextLine().split(" ");
      for(int i = arr.length - 1 ; i >= 0 ; i-- ){
          for(int j = arr[i].length() -1; j >= 0 ;j--){
              System.out.print(arr[i].charAt(j));
          }
          if(i > 0){
              System.out.println(" ");
          }
      }
     String s = "";
     char a =  s.charAt(0);

  }

}
