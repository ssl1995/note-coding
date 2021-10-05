package 读书笔记.Java实战.collection;

import java.util.Set;

/**
 * @author SongShengLin
 * @date 2021/9/5
 */
public class SetDemo {
    public static void main(String[] args) {
        // Set.of，但是不能传递重复元素
        Set<String> set = Set.of("a", "b");
    }
}
