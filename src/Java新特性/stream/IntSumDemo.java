package Java新特性.stream;

import Java新特性.stream.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class IntSumDemo {
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
        // map+sum是没有这种组合的，因为可能出现null；转成reduce写法也有拆装箱出现的null问题
        int mapSum = menu.stream()
                .map(Dish::getCalories).reduce(0, Integer::sum);
        // mapToInt+sum就可以,初选null，sum返回0
        int sum = menu.stream()
                .mapToInt(Dish::getCalories).sum();
        // boxed：可以重新装箱回去
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        intStream.boxed();
        // mapToInt.max：可以显示出现默认0时，改成指定值
        OptionalInt optMax = menu.stream().mapToInt(Dish::getCalories).max();
        int max = optMax.orElse(1);// 出现0时，改成1
    }
}
