package 读书笔记.Java实战.lambda;

import 读书笔记.Java实战.stream.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

/**
 * @author SongShengLin
 * @date 2021/9/6
 */
public class MenuDemo {
    public static void main(String[] args) {
        // 匿名类和Lambda操作局部变量的不同
        int a = 10;
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int a = 2; // 匿名类是可以操作局部变量
                System.out.println(2);
            }
        };
        Runnable r2 = () -> {
            // int a = 2; Lambda表达式不能操作局部变量
            System.out.println(a);
        };


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
        // sum：四种使用方式
        int sum1 = menu.stream().map(Dish::getCalories).reduce(0, (a1, a2) -> a1 + a2);
        int sum2 = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        int sum3 = menu.stream().collect(summingInt(Dish::getCalories));
        int sum4 = menu.stream().mapToInt(Dish::getCalories).sum();

        // 过滤
        menu.stream()// 操作流一样：赛选和抽取，不要再书写以往的普通for
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());


    }
}
