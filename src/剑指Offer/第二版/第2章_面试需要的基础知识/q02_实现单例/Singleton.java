package 剑指Offer.第二版.第2章_面试需要的基础知识.q02_实现单例;

/**
 * @author SongShengLin
 * @date 2021/9/18 5:12 下午
 * @description 实现单例设计模式
 */
public class Singleton {
    /**
     * volatile保证可见性、防止指令重排，不保证原子性
     */
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        // 双端锁外层锁保证singleton实例被创建后，才会加锁，提高效率
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
