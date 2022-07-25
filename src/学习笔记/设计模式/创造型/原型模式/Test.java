package 学习笔记.设计模式.创造型.原型模式;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:48
 * @description
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        Person concretePerson = new ConcretePerson("我叫张三");
        Person clone = (ConcretePerson) concretePerson.clone();

        System.out.println(concretePerson.getName());
        System.out.println(clone.getName());
    }
}
