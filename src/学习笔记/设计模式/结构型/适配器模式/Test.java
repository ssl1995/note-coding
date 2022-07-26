package 学习笔记.设计模式.结构型.适配器模式;

/**
 * @author SongShengLin
 * @date 2022/7/25 23:13
 * @description
 */
public class Test {

    /**
     * 适配器模式
     */
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.adapteeMethod();
        adapter.adapterMethod();
    }
}
