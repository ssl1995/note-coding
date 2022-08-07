package 学习笔记.多线程.completableFuture.电商比价;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author SongShengLin
 * @date 2022/8/7 16:52
 * @description
 */
public class NetMall {
    private final String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double getPriceByName(String productName) {
        return calcPrice(productName);
    }

    private double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() + productName.charAt(0);
    }

    public String getNetMallName() {
        return netMallName;
    }
}
