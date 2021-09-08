package java8.stream;

import java.util.stream.Stream;

/**
 * @author SongShengLin
 * @date 2021/9/5
 */
public class ParallelDemo {

    private static Long sum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    private static Long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()// 并行操作，多核cpu提高性能
                .reduce(0L, Long::sum);
    }
}
