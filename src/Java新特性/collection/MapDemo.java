package Java新特性.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Map.entry;

/**
 * @author SongShengLin
 * @date 2021/9/5
 */
public class MapDemo {
    public static void main(String[] args) {
        // Map.of，适用键值对规模小
        Map<String, Integer> map1 = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

        // Map.ofEntries，适用键值对规模大
        Map<String, Integer> map2 = Map.ofEntries(
                entry("Raphael", 30),
                entry("Olivia", 25),
                entry("Thibaut", 26));

        // for遍历map，笨重
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" + value);
        }
        // forEach遍历map，简洁易读
        map1.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        // comparingByKey：按照key排序
        map1.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        // comparingByValue：按照value排序
        map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        // getOrDefault:没有key=aaa，就返回第二个参数
        map1.getOrDefault("aaa", 111);

        // putIfAbsent:如果map中没有key，就新添加一个key=value进map
        HashMap<String, String> map3 = new HashMap<>();// 修改是动态的，不能用Map.of
        map3.put("a", "1");
        map3.put("b", "2");
        map3.put("c", "3");
        map3.putIfAbsent("a1", "4");// 如果没有，就新添加一个a1=4
        System.out.println(map3);

        // remove:指定key=value删除
        map3.remove("a1", "4");

        // replaceAll：全部key替换为大写
        map3.replaceAll((key, value) -> key.toUpperCase());

        // 合并两个没有重复键值的map
        Map<String, String> family = Map.ofEntries(
                entry("Teo", "Star Wars"), entry("Cristina", "James Bond"));
        Map<String, String> friends = Map.ofEntries(
                entry("Raphael", "Star Wars"));
        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        System.out.println(everyone);

        // merge：可以灵活合并含有重复键值的map
        Map<String, String> family1 = Map.ofEntries(
                entry("Teo", "Star Wars"), entry("Cristina", "James Bond"));
        Map<String, String> friends1 = Map.ofEntries(
                entry("Raphael", "Star Wars"), entry("Cristina", "Matrix"));

        Map<String, String> everyone1 = new HashMap<>(family1);
        friends1.forEach((k, v) ->
                // 第三个参数：如果存在相同的key，就合并value1&value2
                everyone1.merge(k, v, (v1, v2) -> v1 + " & " + v2));
        System.out.println(everyone1);


        // ConcurrentHashMap:指定并行阈值
        ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>();
        long parallelismThreshold = 1;
        Optional<Long> maxValue = Optional.ofNullable(// 获取最大并行数
                concurrentHashMap.reduceValues(parallelismThreshold, Long::max));
        concurrentHashMap.mappingCount();// map的长度long型，比size安全在如果map长度超过int阈值，不会报错
        ConcurrentHashMap.KeySetView<Object, Boolean> objects = ConcurrentHashMap.newKeySet();// 返回变化视图
    }
}
