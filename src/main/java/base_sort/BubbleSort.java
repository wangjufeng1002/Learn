package base_sort;

/**
 * Description: <br>
 * 1. 比较前后相邻的二个数据，如果前面数据大于后面数据，就将这两个数据交换
 * 2. 这样对数据的第0个数据到N-1 个数据进行一次遍历后，最大的一个数据
 * 3. N = N - 1 , 如果 N 不为 0 就重复前面二步，否则排序完成
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/7/7 17:37
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] a ={2,1,4,5,3};
        bubbleSort(a);
        for(int x:a){
            System.out.println(x);
        }
    }
    public static void bubbleSort(int[] a) {
        int i, j;
        for (i = 0; i <  a.length; i++) {
            for(j=0; j< a.length - i -1 ;j++){
                if(a[j] > a[j+1]){
                    int temp ;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]= temp;
                }
            }
        }
    }
}
