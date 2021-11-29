package 剑指Offer.第二版.q02_实现单例;

/**
 * @author SongShengLin
 * @date 2021/9/18 5:12 下午
 * @description 实现单例设计模式
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
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
