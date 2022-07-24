package 学习笔记.设计模式.创造型.创造者模式;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:37
 * @description
 */
public class Test {

    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector();
        Person person = personDirector.constructPerson(new ManBuilder());
        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
    }
}
