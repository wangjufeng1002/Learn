package base_sort;

import java.util.Arrays;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/7/17 16:44
 */
public class MergerSort {

    public static void main(String[] args) {
      /*  int[] a = {2, 3, 4,};
        int[] ints = Arrays.copyOf(a, a.length);

        a[0] = 1;
        System.out.println(ints[0]);*/
        int [] test1={10,3,2,5,6,0,1};
        int[] sort = sort(test1);
        for (int a : sort){
            System.out.println(a);
        }

    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left),sort(right));

    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                if(left.length == 1){
                    left = new int[0];
                }else {
                    left = Arrays.copyOfRange(left, 1, left.length);
                }
            } else {
                result[i++] = right[0];
                if(right.length == 1){
                    right = new int[0];
                }else {
                    right = Arrays.copyOfRange(right, 1, right.length);
                }
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }
        return result;
    }


}
