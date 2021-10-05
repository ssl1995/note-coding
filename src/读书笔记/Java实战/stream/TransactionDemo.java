package 读书笔记.Java实战.stream;

import 读书笔记.Java实战.stream.pojo.Trader;
import 读书笔记.Java实战.stream.pojo.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SongShengLin
 * @date 2021/9/4
 */
public class TransactionDemo {
    public static void main(String[] args) {
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
        // 1.找出2011年发生的所有交易，并按交易额排序
        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        // 2.交易员都在哪些不同的城市工作过
        Set<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
        // 3.查找所有来自剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()// 好习惯，确报没有重复
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        // 4.返回所有交易员的姓名字符串，按字母顺序排序
        String traderStr = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                //.reduce("", (a, b) -> a + b);// 这样效率不是很高，可以换成
                .collect(Collectors.joining());// 后面会将就这种
        // 5.有没有交易员在米兰工作的
        boolean milanMatched = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        // 6.打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .forEach(t -> System.out.println(t.getValue()));
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        // 7.所以交易中，最高的交易额是多少？
        // 8.找到交易额最小的交易?可以直接使用max、min
        Optional<Transaction> max = transactions.stream().max(Comparator.comparing(Transaction::getValue));
        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));

    }
}
