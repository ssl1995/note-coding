package Java新特性.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(5);
        nums.add(3);
        nums.add(9);
        // 普通for操作求和
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        // 使用reduce：求
        int sum1 = nums.stream().reduce(0, (a, b) -> a + b);// (初始值，求和操作)
        int sum2 = nums.stream().reduce(0, Integer::sum);//（初始值，求和操作）使用方法引用
        Optional<Integer> sum3 = nums.stream().reduce(Integer::sum);//（求和操作），所以返回一个Option包装
        // 求最大值和最小值
        Optional<Integer> max = nums.stream().reduce(Integer::max);
        Optional<Integer> min = nums.stream().reduce(Integer::min);
    }
}
