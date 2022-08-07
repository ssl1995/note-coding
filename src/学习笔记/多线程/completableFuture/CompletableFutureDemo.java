package 学习笔记.多线程.completableFuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author SongShengLin
 * @date 2022/8/7 16:38
 * @description
 */
public class CompletableFutureDemo {

    @Test
    public void CompletableFutureTest1() throws ExecutionException, InterruptedException {
        // runAsync:无返回值
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "-----come in");
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----task is over");
        });
        System.out.println(future.get());
    }

    @Test
    public void CompletableFutureTest2() throws ExecutionException, InterruptedException {
        // supplyAsync:有返回值
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "-----come in");
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----task is over");
            return ThreadLocalRandom.current().nextInt(100);
        });
        System.out.println(future.get());
    }

    /**
     * CompletableFuture优点
     * 1. 任务结束，自动回调正确返回的方法
     * 2. 任务异常，自动回调错误方法
     * 3. 主线程设置好回调后，异步任务之间可以顺序执行
     */
    @Test
    public void CompletableFutureTest3() {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "-----come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----计算结束耗时1秒钟，result： " + result);
            if (result > 6) {
                int age = 10 / 0;
            }
            return result;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("-----result: " + v);
            }
        }).exceptionally(e -> {
            System.out.println("-----exception: " + e.getCause() + "\t" + e.getMessage());
            return -44;
        });

        //主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:暂停3秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
