package 读书笔记.数据结构By慕课网.工具类;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {
    }
    // 有序数组
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // 随机数组，每个数字的范围是 [0, bound)
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++){
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}
