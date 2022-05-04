package 面试记录.设计模式.单例设计模式;

/**
 * @author SongShengLin
 * @date 2022/4/10 15:08
 * @description
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getSingleton();
        Singleton1 singleton2 = Singleton1.getSingleton();
        System.out.println(singleton1.toString());
        System.out.println(singleton2.toString());
    }
}
