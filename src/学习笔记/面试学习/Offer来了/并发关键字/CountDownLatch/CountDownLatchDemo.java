package 学习笔记.面试学习.Offer来了.并发关键字.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author SongShengLin
 * @date 2022/3/17 00:07
 * @description
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        System.out.println("开始等待两个子线程执行完毕");
        new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ",执行了");

                countDownLatch.countDown();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "线程1").start();

        new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ",执行了");

                countDownLatch.countDown();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "线程2").start();

        try {
            // 等待信号量2结束
            countDownLatch.await();

            System.out.println("两个子线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
