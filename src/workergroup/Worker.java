package workergroup;

/**
 * @author SongShengLin
 * @date 2021/9/16 10:36 下午
 * @description
 */
public class Worker {
    // 年纪
    private int age;
    // 性别:0-男，1-女
    private int sex;
    // 入职时间混排，其实是不用定义的
    // private Date hireDate;

    public Worker() {
    }

    public Worker(int age) {
        this.age = age;
    }

    public Worker(int age, int sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
