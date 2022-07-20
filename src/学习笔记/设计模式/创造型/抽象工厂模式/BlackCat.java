package 学习笔记.设计模式.创造型.抽象工厂模式;

/**
 * @author SongShengLin
 * @date 2022/7/20 22:38
 * @description
 */
public class BlackCat implements ICat {
    @Override
    public void eat() {
        System.out.println("BlackCat is eating!");
    }
}
