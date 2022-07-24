package 学习笔记.设计模式.创造型.创造者模式;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:28
 * @description
 */
public interface PersonBuilder {

    void buildHead();

    void buildBody();

    void buildFoot();

    Person buildPerson();


}
