package 学习笔记.设计模式.创造型.抽象工厂模式;

/**
 * @author SongShengLin
 * @date 2022/7/20 22:42
 * @description
 */
public class BlackDog implements IDog {
    @Override
    public void eat() {
        System.out.println("BlackDog is eating!");
    }
}
