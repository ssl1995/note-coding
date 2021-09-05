package Java新特性.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class RangeClosedDemo {
    public static void main(String[] args) {
        // 随机生成[1,100),偶数个数
        long count1 = IntStream.range(1, 100).filter(x -> x % 2 == 0).count();
        // 随机生成[1,100],偶数个数
        long count2 = IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).count();

        // 手写一个[1,100]内的勾股数组
        Stream<double[]> res = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));// 三元组中第三个数必须是整数
    }
}
