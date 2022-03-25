package 面试记录.设计模式.单例设计模式;

/**
 * @author SongShengLin
 * @date 2022/3/24 16:58
 * @description
 */
public class Singleton3 {

    private static Singleton3 singleton = null;

    private Singleton3() {
    }

    public static Singleton3 getSingleton() {
        if (singleton == null) {
            // 问题：不是真正的线程安全.因为可能a，b同时进来到这一步
            synchronized (Singleton3.class) {
                singleton = new Singleton3();
            }
        }
        return singleton;
    }


}
