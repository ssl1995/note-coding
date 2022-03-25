package 面试记录.设计模式.单例设计模式;

/**
 * @author SongShengLin
 * @date 2022/3/24 16:58
 * @description
 */
public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {
    }

    /**
     * 考虑三点：是否懒加载、线程安全、能否被反射破坏
     */
    public static Singleton getSingleton() {
        // 懒汉式：存在线程安全问题
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }


}
