package 学习笔记.面试学习.多线程.创建线程;

/**
 * @author SongShengLin
 * @date 2022/4/10 17:17
 * @description
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            System.out.println(getName() + "执行第" + i + "次");

            try {
                // 线程休眠1s后，再执行
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        // 线程启动start，而不是run;并且只启动一次
        myThread1.start();
    }
}
