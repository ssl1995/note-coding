package 学习笔记.多线程.Java锁.Syn锁;

/**
 * @author SongShengLin
 * @date 2022/7/27 21:34
 * @description
 */
public class ClassDemo {

    private Object object = new Object();

    public static void main(String[] args) {

    }

    public void m1() {
        synchronized (object) {
            System.out.println("syn修饰代码块");
        }
    }


    public synchronized void m2() {

    }

    public static synchronized void m3() {

    }
}
