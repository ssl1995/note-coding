package 学习笔记.Java8新特性.Optional;

import java.time.Period;
import java.util.Optional;

/**
 * @Author: SongShengLin
 * @Date: 2022/07/21 11:55
 * @Describe:
 */
public class OptionalTest {
    public static void main(String[] args) {
        Person person = new Person();
        Optional.ofNullable(person.getName());

    }

    static class Person {
        public String name;
        public Integer age;

        public Person() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
