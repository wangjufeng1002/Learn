package concurrent.completableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/7/16 16:16
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime  = ((System.nanoTime() - start)) / 1_000_000;
        System.out.println("Invocation returned after "+invocationTime);
        //执行更多任务
        Double price = futurePrice.get();
        System.out.printf("Price is %.2f%n", price);


        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");



    }
}
