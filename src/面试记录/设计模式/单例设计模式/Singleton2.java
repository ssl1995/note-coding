package 面试记录.设计模式.单例设计模式;

/**
 * @author SongShengLin
 * @date 2022/3/24 16:58
 * @description
 */
public class Singleton2 {

    private static Singleton2 singleton = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getSingleton() {
        // 问题：如果多次不用，饿汉式浪费内存
        return singleton;
    }


}
