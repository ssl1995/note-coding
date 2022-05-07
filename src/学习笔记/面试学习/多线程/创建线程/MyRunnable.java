package 学习笔记.面试学习.多线程.创建线程;

/**
 * @author SongShengLin
 * @date 2022/4/10 17:23
 * @description
 */
public class MyRunnable implements Runnable {
    private int i = 1;

    @Override
    public void run() {
        while (i < 10) {
            System.out.println(Thread.currentThread().getName() + "：正在执行！" + i++);
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        // 各个线程间使用同一个runnable，资源共享
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        Thread thread2 = new Thread(myRunnable);
        thread2.start();

    }

}
