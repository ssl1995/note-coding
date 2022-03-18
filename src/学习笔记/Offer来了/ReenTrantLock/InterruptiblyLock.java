package 学习笔记.Offer来了.ReenTrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SongShengLin
 * @date 2022/3/16 23:17
 * @description
 */
public class InterruptiblyLock {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    /**
     * ReentrantLock的可相应中断
     */
    public static void main(String[] args) {

        long curTime = System.currentTimeMillis();


        Thread thread1 = new Thread(() -> {

            try {
                // 如果当前线程未被中断，则获取锁
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "，执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 判断当前线程是否持有锁，如果持有就释放
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }

                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "，退出");

            }

        }, "线程1");

        Thread thread2 = new Thread(() -> {

            try {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "，执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 判断当前线程是否持有锁，如果持有就释放
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }

                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "，退出");

            }

        }, "线程2");

        thread1.start();
        thread2.start();


        while (true) {
            if (System.currentTimeMillis() - curTime >= 3000) {
                // 响应式中断线程2，让线程1走完
                thread2.interrupt();
            }
        }

    }
}
