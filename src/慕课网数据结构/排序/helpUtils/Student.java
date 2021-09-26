package 慕课网数据结构.排序.helpUtils;

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
        重写equals：实现一个基于username的比较
            1 当前类==obj，true
            2 obj是否为空||当前类与obj的类不同，false
            3 强转obj，返回比价属性
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return Objects.equals(this.username, student.username);
    }


    /*
        重写compareTo：基于成绩的比较
     */
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
