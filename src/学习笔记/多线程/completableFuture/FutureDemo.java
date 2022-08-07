package 学习笔记.多线程.completableFuture;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author SongShengLin
 * @date 2022/8/7 16:22
 * @description
 */
public class FutureDemo {

    @Test
    public void futureGetTest() throws ExecutionException, InterruptedException, TimeoutException {
        // 业务逻辑
        FutureTask futureTask = new FutureTask(() -> {
            System.out.println("-----come in FutureTask");
            // 假设业务逻辑要运行3秒
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "" + ThreadLocalRandom.current().nextInt(100);
        });
        // 线程去执行这段业务逻辑
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();

        // 3秒钟后才出来结果，还没有计算你提前来拿(只要一调用get方法，对于结果就是不见不散，会导致阻塞) = 阻塞
//        System.out.println(Thread.currentThread().getName() + "\t" + futureTask.get());

        // 3秒钟后才出来结果，我只想等待1秒钟，过时不候 = 抛出异常:java.util.concurrent.TimeoutException
        System.out.println(Thread.currentThread().getName() + "\t" + futureTask.get(1L, TimeUnit.SECONDS));

        // 执行到这里
        System.out.println(Thread.currentThread().getName() + "\t" + " run... here");
    }

    @Test
    public void isDomeDemo() throws ExecutionException, InterruptedException, TimeoutException {
        // 业务逻辑
        FutureTask futureTask = new FutureTask(() -> {
            System.out.println("-----come in FutureTask");
            // 假设业务逻辑要运行3秒
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "" + ThreadLocalRandom.current().nextInt(100);
        });
        // 线程去执行这段业务逻辑
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();

        // main线程完成任务
        System.out.println(Thread.currentThread().getName() + "\t" + " 完成任务！");

        // 轮询方式：获取future的结果
        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            }
        }
    }
}
