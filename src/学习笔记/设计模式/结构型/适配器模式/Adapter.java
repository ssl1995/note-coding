package 学习笔记.设计模式.结构型.适配器模式;

/**
 * @author SongShengLin
 * @date 2022/7/25 23:10
 * @description
 */
public class Adapter implements Target {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void adapteeMethod() {
        adaptee.adapteeMethod();
    }

    @Override
    public void adapterMethod() {
        System.out.println("Adapter Method！");
    }
}
