package 学习笔记.Java8新特性.新的时间类型;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: SongShengLin
 * @Date: 2022/07/21 12:56
 * @Describe:
 */
public class LocalTimeDemo {

    @Test
    public void date2String() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        String dateStr = formatter.format(now);
        System.out.println(dateStr);
    }


    @Test
    public void String2Date() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String date = "2022-07-21 12:59:17";
        LocalDateTime parse = LocalDateTime.parse(date, formatter);
        System.out.println(parse);
    }


}
