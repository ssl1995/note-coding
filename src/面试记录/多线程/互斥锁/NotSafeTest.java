package 面试记录.多线程.互斥锁;

/**
 * @author SongShengLin
 * @date 2022/4/15 11:50
 * @description
 */
public class NotSafeTest {

    private static int count = 0;

    private void addOne() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    private int getCount() {
        return count;
    }

    public static int calc() {
        final NotSafeTest test = new NotSafeTest();
        Thread thread1 = new Thread(test::addOne, "线程1");
        Thread thread2 = new Thread(test::addOne, "线程2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 最后输出的count值肯定不是20000,因为线程1,线程2优先去刷新的是CPU缓存里的值
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NotSafeTest.calc());
    }
}
