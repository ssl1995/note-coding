package 学习笔记.设计模式.创造型.创造者模式;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:33
 * @description
 */
public class ManBuilder implements PersonBuilder {

    Person person;

    public ManBuilder() {
        this.person = new Man();
    }

    @Override
    public void buildHead() {
        person.setHead("男人的头");
    }

    @Override
    public void buildBody() {
        person.setBody("男人的身体");

    }

    @Override
    public void buildFoot() {
        person.setFoot("男人的脚");

    }

    @Override
    public Person buildPerson() {
        return this.person;
    }
}
