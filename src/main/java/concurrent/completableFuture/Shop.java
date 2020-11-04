package concurrent.completableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/7/16 16:07
 */
public class Shop {

    private String name;


    Random random = new Random();
    public double getPrice(String product){
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product){
        //创建CompletableFuture对象，它会包含计算结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            try {
                double price = calculatePrice(product);//在另一个线程中以异步方式执行计算
                futurePrice.complete(price);    //需长时间计算的任务结束并得出结果时，设置Future的返回值
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    public Future<Double>  getPriceAsyncV2(String product){
        CompletableFuture.runAsync(()->calculatePrice(product));
        return CompletableFuture.supplyAsync(()->calculatePrice(product)).whenComplete((a,b)->{
            System.out.println(a+ "   " + b);
        });
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Double> aaaa = new Shop().getPriceAsyncV2("aaaa");
        System.out.println(aaaa.get());
    }

    private double calculatePrice(String product){
        delay();
        return random.nextDouble() * product.charAt(0)+product.charAt(1);
    }

    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public Shop(String name) {
        this.name = name;
    }

    public Shop() {
    }

}
