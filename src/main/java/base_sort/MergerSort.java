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
        int[] test1 = {10, 3, 2, 5, 6, 0, 1};
        int[] sort = sort_V1(test1);
       /* for (int a : sort) {
            System.out.println(a);
        }*/
        int i=0;
        int a=0;
        System.out.println(a=i++);
        System.out.println(i);

    }

    public static int[] sort_V1(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge_V1(sort_V1(left), sort_V1(right));

    }

    public static int[] merge_V1(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                if (left.length == 1) {
                    left = new int[0];
                } else {
                    left = Arrays.copyOfRange(left, 1, left.length);
                }
            } else {
                result[i++] = right[0];
                if (right.length == 1) {
                    right = new int[0];
                } else {
                    right = Arrays.copyOfRange(right, 1, right.length);
                }
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }


    public void merge_sort(int[] a, int n) {

    }

    public void merge_sort_c(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        merge_sort_c(a, p, q);
        merge_sort_c(a, q + 1, r);
    }

    public void merge(int[] a, int p, int r) {
        int q = (p + r) / 2;
        int i = p, j = q + 1, k = 0;
        int[] temp = new int[r - p];
        while (i <= q && j <= r) {
            if(a[i]<=a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[i++];
            }
        }

    }
}
