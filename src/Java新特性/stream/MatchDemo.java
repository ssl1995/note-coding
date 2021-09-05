package Java新特性.stream;

import Java新特性.stream.pojo.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class MatchDemo {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        // anyMatch：至少有一个。是否匹配
        if (specialMenu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("isMath()");
        }
        // allMath与noneMath:查看范围的全部，是否匹配
        specialMenu.stream().allMatch(dish -> dish.getCalories() < 1000);
        specialMenu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
    }
}
