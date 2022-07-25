package 学习笔记.设计模式.创造型.原型模式;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:46
 * @description
 */
public class Person implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
