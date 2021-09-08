package java8.stream;

import java8.stream.pojo.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * @author SongShengLin
 * @date 2021/9/5
 */
public class PartitionedDemo {
    public static void main(String[] args) {
        List<Dish> menu = asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        // partitioningBy：按照是否是蔬菜分区,返回的是true和false
        Map<Boolean, List<Dish>> isVMenuMap = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(isVMenuMap.get(true));
        // 也可以用之前学的filter赛选
        List<Dish> isVMenuList = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(isVMenuList);

        // 分区的优势：可以通过true和false进行更多的操作
        Map<Boolean, Map<Boolean, List<Dish>>> isVByType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        groupingBy(Dish::isVegetarian)));// 第二个参数指定二级收集器
        System.out.println(isVByType);
        Map<Boolean, Dish> mostCPartitionByV = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCPartitionByV);

        // 判断质数和非质数
        Map<Boolean, List<Integer>> isPrimList = partitionPrime(10);
        System.out.println(isPrimList.get(true));
        System.out.println(isPrimList.get(false));
    }

    // 利用partitioningBy，判断[2,n]有哪些质数
    private static Map<Boolean, List<Integer>> partitionPrime(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(i -> isPrime(i)));
             // .collect(partitioningBy(this::isPrime));更方便的写法
    }

    // 判断是否是质数
    private static boolean isPrime(int n) {
        int sqrtN = (int) Math.sqrt(n);
        // [0,srtN]内是否有数能把n整数，没有就返回true
        return IntStream.rangeClosed(2, sqrtN).noneMatch(i -> n % i == 0);
    }
}
