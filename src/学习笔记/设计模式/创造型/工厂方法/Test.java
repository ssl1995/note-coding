package 学习笔记.设计模式.创造型.工厂方法;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:19
 * @description
 */
public class Test {

    public static void main(String[] args) {
        StudentWorkFactory studentWorkFactory = new StudentWorkFactory();
        Iwork studentWork = studentWorkFactory.getWork();
        studentWork.work();

        TeacherWorkFactory teacherWorkFactory = new TeacherWorkFactory();
        Iwork teacherWork = teacherWorkFactory.getWork();
        teacherWork.work();
    }

}
