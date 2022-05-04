package 面试记录.多线程.创建线程;

/**
 * @author SongShengLin
 * @date 2022/4/10 17:46
 * @description
 */
public class MyJoin extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            System.out.println(getName() + "执行第" + i + "次");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyJoin myJoin = new MyJoin();

        myJoin.start();

        myJoin.join();


        // 调用join的线程执行完毕，其余线程才会执行
        for (int i = 1; i <= 5; i++) {
            System.out.println("主线程" + "执行第" + i + "次");
        }
        System.out.println("主线程结束！");

    }
}
