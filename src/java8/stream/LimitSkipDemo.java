package java8.stream;

import java8.stream.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class LimitSkipDemo {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        // 赛选出已经按照卡路里排好序的，卡路里<or>320的菜单
        // java8:使用filter，缺点是原list已经按照卡路里排好序了，没必要全部遍历一遍
        List<Dish> filterList =
                specialMenu.stream().filter(dish -> dish.getCalories() < 320).collect(Collectors.toList());
        // java9:由于原list已经提供按照卡路里排好序啦，无需全部遍历，java9提供了更方便的api
        List<Dish> takeWhileList =
                specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(Collectors.toList());
        List<Dish> dropWhileList =
                specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(Collectors.toList());

        // limit:截短流，可以用在无序上
        List<Dish> limitDishes = specialMenu.stream().filter(dish -> dish.getCalories() > 300)
                .limit(3).collect(Collectors.toList());
        // skip:跳过流
        List<Dish> skipDishes = specialMenu.stream().filter(dish -> dish.getCalories() > 300)
                .skip(2).collect(Collectors.toList());
    }
}
