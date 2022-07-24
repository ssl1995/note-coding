package 学习笔记.Java8新特性.函数式接口;

@FunctionalInterface
public interface MyFuncTwo<T, R> {

    /**
     * Function< T,R > 两个参数的函数式接口
     */
    R getValue(T t1, T t2);

    /**
     * 四大核心的函数式接口
     * Consumer:void getValue(T t)
     * Supplier:T getValue()
     * Function:R getValue(T t )
     * Predicate:boolean getValue(T t)
     */
}
