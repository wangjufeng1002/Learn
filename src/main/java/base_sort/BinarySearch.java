package base_sort;

/**
 * Description: <br> 二分查找法
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/7/7 17:11
 */
public class BinarySearch {

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6};
        int a = 6;
        System.out.println(biSearch(array,a));
    }
    public static int biSearch(int[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            // mid 为中间位置
            mid = (lo + hi) / 2;
            if (array[mid] == a) {
                return mid;
            } else if (array[mid] < a) {
                //向右查找
                lo = mid + 1;
            } else {
                //向左查找
                hi = mid - 1;
            }

        }
        return -1;
    }
}
