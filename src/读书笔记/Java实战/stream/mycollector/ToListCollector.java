package 读书笔记.Java实战.stream.mycollector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author SongShengLin
 * @date 2021/9/5
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    @Override
    public Supplier<List<T>> supplier() {// 建立结果容器
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {// 将元素添加到结果容器
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {// 合并两个容器结果，供归约操作使用的函数
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {// 对容器结果最终转换
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {// 定义收集器行为以及优化提示
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH,// 累加器对象直接用作归约结果
                Characteristics.CONCURRENT));// 可被多个线程调用，可以并行归约
    }
}
