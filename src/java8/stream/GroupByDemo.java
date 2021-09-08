package java8.stream;

import java8.stream.pojo.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * @author SongShengLin
 * @date 2021/9/5
 */
public class GroupByDemo {
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
        // 1.对元素进行操作
        // 按照某个原有方法进行分组
        Map<Dish.Type, List<Dish>> listMap = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(listMap);
        // 自定义分组逻辑
        Map<String, List<Dish>> listMap1 = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) return "DIET";
            else if (dish.getCalories() <= 700) return "NORMAL";
            else return "FAT";
        }));
        System.out.println(listMap1);

        // 按照某种规则分组，不想丢失分组key，就不能用filter+collect
        Map<Dish.Type, List<Dish>> f1 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(groupingBy(Dish::getType));// 会丢失不存在type
        System.out.println(f1);
        Map<Dish.Type, List<Dish>> f2 = menu.stream()
                .collect(groupingBy(Dish::getType,// 第二参数，不会丢失
                        filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println(f2);
        Map<Dish.Type, List<String>> f3 = menu.stream()
                .collect(groupingBy(Dish::getType,// 第二参数，value改回指定类型,和第28行输出结果一样
                        mapping(Dish::getName, toList())));
        System.out.println(f3);

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));
        // 取出类型，再去另一个表根据类型查出标签去重，返回Map
        // 这个操作更想数据库多表关联查询,这个思想很重要
        Map<Dish.Type, Set<String>> dishNamesByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        flatMapping(dish -> dishTags.get(dish.getName()).stream(),
                                toSet())));// set删除重复标签
        System.out.println(dishNamesByType);

        Map<Dish.Type, HashSet<String>> dishNamesByType2HashSet = menu.stream()
                .collect(groupingBy(Dish::getType,
                        flatMapping(dish -> dishTags.get(dish.getName()).stream(),
                                toCollection(HashSet::new))));// 指定set为HashSet类型

        // 2.多级分组
        Map<Dish.Type, Map<String, List<Dish>>> mapMap = menu.stream().collect(groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return "DIET";
                    else if (dish.getCalories() <= 700) return "NORMAL";
                    else return "FAT";
                })
        ));
        System.out.println(mapMap);

        // 3.按子数组进行收集
        // value选出最高卡路里，会被Option包装，但是如果出现null。option本来就不会出现，所以没有用
        Map<Dish.Type, Optional<Dish>> mostCByType = menu.stream().collect(groupingBy(Dish::getType,
                maxBy(Comparator.comparingInt(Dish::getCalories))));
        // {OTHER=Optional[pizza], FISH=Optional[salmon], MEAT=Optional[pork]}
        System.out.println(mostCByType);
        // 使用collectingAndThen包装，取消掉没用的Option
        Map<Dish.Type, Dish> mostCByType1 = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)
        ));
        Map<Dish.Type, Dish> mostCByType2 = menu.stream().collect(toMap(// 上面优化等价下面这种写法
                Dish::getType, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCByType1);
        System.out.println(mostCByType2);

        // 累加所有的卡路里
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));


    }
}
