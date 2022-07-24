package 学习笔记.设计模式.创造型.工厂方法;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:19
 * @description
 */
public class TeacherWorkFactory implements WorkFactory {
    @Override
    public Iwork getWork() {
        return new TeacherWork();
    }
}
