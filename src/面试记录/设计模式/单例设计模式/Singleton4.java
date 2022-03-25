package 面试记录.设计模式.单例设计模式;

/**
 * @author SongShengLin
 * @date 2022/3/24 16:58
 * @description
 */
public class Singleton4 {

    private static Singleton4 singleton = null;

    private Singleton4() {
    }

    public static Singleton4 getSingleton() {
        if (singleton == null) {
            // 问题：不是真正的线程安全.因为可能a，b同时进来到这一步
            synchronized (Singleton4.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }


}
