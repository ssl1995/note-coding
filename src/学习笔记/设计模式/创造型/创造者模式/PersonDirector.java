package 学习笔记.设计模式.创造型.创造者模式;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:35
 * @description
 */
public class PersonDirector {

    public Person constructPerson(PersonBuilder pb) {
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.buildPerson();
    }
}
