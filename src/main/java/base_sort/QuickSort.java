package base_sort;

import java.util.Arrays;

/**
 * Description: <br> 快速排序
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/7/8 16:40
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] a = {0, 2, 4, 5, 6, 7, 8, 1};
        int[] a = {3, 0, -1, 2, -4, 7, 8, 1};
        //sort(a,0,a.length-1);
        a = sort(a);
        for (int x : a) {
            System.out.println(x);
        }
    }

    public static void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];
        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key) {
                end--;
                if (a[end] < key) {
                    int temp = a[end];
                    a[end] = a[start];
                    a[start] = temp;
                }
            }
            while (end > start && a[start] <= key) {
                start++;
                if (a[start] >= key) {
                    int temp = a[start];
                    a[start] = a[end];
                    a[end] = temp;
                }
            }
        }
        if (start > low) {
            sort(a, low, start - 1);
        }
        if (end < high) {
            sort(a, end + 1, high);
        }
    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, arr.length - 1);
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //设定基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
