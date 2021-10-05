package 读书笔记.Java实战.stream;

import 读书笔记.Java实战.stream.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class FindAnyDemo {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        // findAny：查找返回任意一个元素
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> {
            System.out.println("find()");
        });
        // findFirst:查找第一个过滤出的元素
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst(); // 9

    }
}
