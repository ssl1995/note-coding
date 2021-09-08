package java8.collection;

import java8.stream.pojo.Trader;
import java8.stream.pojo.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/9/5
 */
public class ListDemo {
    public static void main(String[] args) {
        // 老式创建List
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Raphael");
        friends.add("Olivia");
        friends.add("Thibaut");
        // Java9提供了List的工厂创建，缺点是只能更新，不能删除、增加
        List<String> friends1 = Arrays.asList("Raphael", "Olivia", "Thibaut");
        // friends1.add("1"); // 抛出异常

        // List.Of，返回一个list
        // 与Arrays.asList不同，List.of创建的list不可修改，初始化是啥就是啥
        List<String> list = List.of("Raphael", "Olivia", "Thibaut");


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        // 学习List，java8新特性
        // removeIf：更加方便的删除逻辑
        transactions.removeIf(t -> Character.isDigit(t.getTrader().getName().charAt(0)));
        // replaceAll：在原集合上，将原先的首字符大写，不要增加新的list
        List<String> strList = Arrays.asList("a12", "c14", "b13");
        strList.replaceAll(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1));
        System.out.println(strList);
    }
}
