package 读书笔记.Java实战.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class FlapMapDemo {
    public static void main(String[] args) {
        String[] words = {"Hello", "World"};
        List<String[]> mapList = Arrays.stream(words)
                .map(word -> word.split(""))// split会映射成一个数组
                .distinct().collect(Collectors.toList());
        List<String> flapMapList = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)// 不想要数组，而是将数组每个元素映射成一个个流，使用flapMap
                .distinct().collect(Collectors.toList());
    }
}
