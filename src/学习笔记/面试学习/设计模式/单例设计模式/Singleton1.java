package 学习笔记.面试学习.设计模式.单例设计模式;

/**
 * @author SongShengLin
 * @date 2022/3/24 16:58
 * @description
 */
public class Singleton1 {

    private static Singleton1 singleton = null;

    private Singleton1() {
    }

    public static synchronized Singleton1 getSingleton() {
        // 问题：容易阻塞，性能不好
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }


}
