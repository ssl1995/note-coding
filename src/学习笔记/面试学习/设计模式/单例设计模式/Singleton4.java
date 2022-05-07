package 学习笔记.面试学习.设计模式.单例设计模式;

/**
 * @author SongShengLin
 * @date 2022/3/24 16:58
 * @description
 */
public class Singleton4 {

    /**
     * 加volatile防止指令重排
     */
    private static volatile Singleton4 singleton = null;

    private Singleton4() {
    }

    public static Singleton4 getSingleton() {
        // 双重锁
        if (singleton == null) {
            synchronized (Singleton4.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }


}
