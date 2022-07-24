package 学习笔记.Java8新特性.函数式接口;

@FunctionalInterface
public interface MyFunc<T> {

    /**
     * 函数式接口：一个接口@FunctionalInterface；并且只能有一个抽象方法
     * 方法名不重要，并不会使用
     *
     */
    public T getValue(T t);

}
