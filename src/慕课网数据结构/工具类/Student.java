package 慕课网数据结构.工具类;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String username;
    private int score;

    public Student() {
    }

    public Student(String username) {
        this.username = username;
    }

    public Student(String username, int score) {
        this.username = username;
        this.score = score;
    }

    /*
        使用什么成员实现"相等",重写equals方法：实现一个基于username的比较
            1 当前类==obj，true
            2 obj是否为空||当前类与obj的类不同，false
            3 强转obj为当前类
            4 指定比较属性是username
     */
    // 相等的比较
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        // 强转
        Student student = (Student) obj;
        // 指定比较属性
        return Objects.equals(this.username, student.username);
    }

    // 排序的比较：实现Comparable接口，重写compareTo方法
    @Override
    public int compareTo(Student student) {
        // this在前就是从大到小排序
        return this.score - student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}
