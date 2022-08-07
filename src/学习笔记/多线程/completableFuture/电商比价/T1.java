package 学习笔记.多线程.completableFuture.电商比价;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @auther zzyy
 * @create 2020-06-28 10:07
 */
public class T1 {
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("tmall"),
            new NetMall("pdd"),
            new NetMall("mi")
    );

    public static List<String> findPriceSync(List<NetMall> list, String productName) {
        return list.stream()
                .map(mall -> String.format(productName + " %s price is %.2f",
                        mall.getNetMallName(),
                        mall.getPriceByName(productName)))
                .collect(Collectors.toList());
    }

    public static List<String> findPriceASync(List<NetMall> list, String productName) {
        return list.stream()
                .map(mall -> CompletableFuture.supplyAsync(() -> String.format(productName + " %s price is %.2f",
                        mall.getNetMallName(),
                        mall.getPriceByName(productName))))
                .collect(Collectors.toList())
                .stream().map(CompletableFuture::join)// Future的join不抛出异常
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> list1 = findPriceSync(list, "thinking in java");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + " 毫秒");

        long startTime2 = System.currentTimeMillis();
        List<String> list2 = findPriceASync(list, "thinking in java");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime2 - startTime2) + " 毫秒");
    }
}

