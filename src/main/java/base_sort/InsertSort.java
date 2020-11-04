package base_sort;

import java.util.Arrays;

/**
 * Description: <br> 插入排序
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/7/7 19:10
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {3,2,1,4};

        sort(array);
        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //插入的数
            int insertVal = array[i];
            //被插入的位置(准备和前一个数字比较)
            int index = i - 1;
            //如果插入的数比被插入的数小
            while (index >= 0 && insertVal < array[index]) {
                //将把array[index] 向后移动
                 array[index + 1] = array[index];
                //让index向前移动
                index--;
            }
            array[index + 1] = insertVal;
        }
    }

    public static int[] sort_2(int[] array) {
        //对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(array, array.length);
        //从下标 为 1 的元素开始选择合适的位置插入，因为下标
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
