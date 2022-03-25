package 面试记录.设计模式.单例设计模式;

/**
 * @author SongShengLin
 * @date 2022/3/24 16:58
 * @description
 */
public class Singleton5 {

    private static volatile Singleton5 singleton = null;

    private Singleton5() {
    }

    public static Singleton5 getSingleton() {
        if (singleton == null) {
            // 加volatile防止指令重排
            synchronized (Singleton5.class) {
                if (singleton == null) {
                    singleton = new Singleton5();
                }
            }
        }
        return singleton;
    }


}
