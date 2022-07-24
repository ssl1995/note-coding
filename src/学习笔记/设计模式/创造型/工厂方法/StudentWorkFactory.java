package 学习笔记.设计模式.创造型.工厂方法;

/**
 * @author SongShengLin
 * @date 2022/7/24 14:18
 * @description
 */
public class StudentWorkFactory implements WorkFactory {
    @Override
    public Iwork getWork() {
        return new StudentWork();
    }
}
