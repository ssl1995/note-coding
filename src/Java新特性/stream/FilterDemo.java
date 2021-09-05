package Java新特性.stream;

import Java新特性.stream.pojo.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author SongShengLin≤
 * @date 2021/9/4
 */
public class FilterDemo {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        System.out.println("4.3.2-练习题");
        // 普通迭代
        List<String> highCaloricDishes = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if (dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }
        System.out.println(highCaloricDishes);
        // 普通迭代转换为stream
        List<String> highCaloricDishes1 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName).collect(Collectors.toList());
        System.out.println(highCaloricDishes1);

        // filter:返回一个谓词
        List<Dish> res1 = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        // distinct:赛选出不同的值
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(x -> x % 2 == 0).distinct()
                .forEach(System.out::println);
        // map:映射成另一个类
        List<Integer> mapList = menu.stream()
                .map(Dish::getName).map(String::length)
                .collect(Collectors.toList());

        // 收集器
        // 获取流中最大值
        Optional<Dish> max1 = menu.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories)));
        Optional<Dish> max2 = menu.stream().max(Comparator.comparingInt(Dish::getCalories));

        // 求和
        int totalCalories1 = menu.stream().collect(summingInt(Dish::getCalories));
        int totalCalories2 = menu.stream().mapToInt(Dish::getCalories).sum();

        // 汇总所有collect操作结果:summarizingInt
        IntSummaryStatistics summaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        long summarySum = summaryStatistics.getSum();
        int summaryMax = summaryStatistics.getMax();
        double summaryAve = summaryStatistics.getAverage();

        // 拼接字符串,joining内部使用StringBuilder来拼接，性能较好
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);
        String shortMenu1 = menu.stream().map(Dish::getName).collect(joining(", "));//
        System.out.println(shortMenu1);

        // 收集器通用reduce方法,第一种是通用的写法，第二、三种更易读
        int total1 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        int total2 = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        int total3 = menu.stream().mapToInt(Dish::getCalories).sum();// 避免拆装箱，性能最好

    }
}
