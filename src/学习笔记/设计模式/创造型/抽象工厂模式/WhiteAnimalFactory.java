package 学习笔记.设计模式.创造型.抽象工厂模式;

/**
 * @author SongShengLin
 * @date 2022/7/20 22:40
 * @description
 */
public class WhiteAnimalFactory implements IAnimalFactory {
    @Override
    public ICat createCat() {
        return new WhiteCat();
    }

    @Override
    public IDog createDog() {
        return new WhiteDog();
    }
}
