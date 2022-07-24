package 学习笔记.Java8新特性.函数式接口;

import org.junit.jupiter.api.Test;

/**
 * @Author: SongShengLin
 * @Date: 2022/07/21 11:00
 * @Describe:
 */
public class MyFuncTwoTest {

    private Long getSum(MyFuncTwo<Long, Long> myFuncTwo, Long a, Long b) {
        return myFuncTwo.getValue(a, b);
    }

    @Test
    public void test1() {
        Long sum = getSum((a, b) -> a + b, 100L, 200L);
        System.out.println(sum);
//        getSum(Long::sum, 100L, 200L);
    }
}
