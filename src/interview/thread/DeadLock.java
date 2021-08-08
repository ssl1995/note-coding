package interview.thread;

public class DeadLock {
    // 手写一个死锁
    private static final Object r1 = new Object();
    private static final Object r2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (r1) {
                System.out.println(Thread.currentThread().getName() + " get r1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r2) {
                    System.out.println(Thread.currentThread().getName() + " get r2");
                }
            }

        }, "thread1").start();

        new Thread(() -> {
            synchronized (r2) {
                System.out.println(Thread.currentThread().getName() + " get r2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r1) {
                    System.out.println(Thread.currentThread().getName() + " get r1");
                }
            }

        }, "thread2").start();
    }
}
