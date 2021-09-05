package Java新特性.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class StreamDemo {
    public static void main(String[] args) {
        // 由Stream创建流
        Stream<String> stream = Stream.of("Modern ", " Java  ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // ofNullable：null也可以创建一个Steam
        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        // Arrays.stream：将数组转化成一个流，更方便的进行sum等操作
        int[] nums = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(nums).sum();

        // 统计项目目录下，data.txt中不同单词的数量
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct().count();
        } catch (IOException ignored) {
        }
        System.out.println(uniqueWords);

        // 统计项目目录下，data.txt中最高频单词
        String maxCountWord = "";
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            maxCountWord = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .sorted().findFirst().get();
        } catch (IOException ignored) {
        }
        System.out.println(maxCountWord);

        // 统计项目目录下，data.txt中最低频单词
        String minCountWord = "";
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            minCountWord = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .sorted(Comparator.reverseOrder()).findFirst().get();
        } catch (IOException ignored) {
        }
        System.out.println(minCountWord);

        // 学习两个无限流，需要用limit限制使用次数
        // 随机打印前10个偶数，并打印
        Stream.iterate(0, x -> x + 2).limit(10).forEach(System.out::println);

        // 随机生成5个数，并打印
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
}
