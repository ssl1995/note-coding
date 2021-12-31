package 学习笔记.牛客算法课.中级班.课2.Q02_magic次数;

import java.util.Arrays;
import java.util.HashSet;

public class MagicOp {
    // 最多可以进行多少次magic操作？
    // 请保证arr1无重复值、arr2中无重复值，且arr1和arr2肯定有数字
    public static int maxOps(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int num : arr1) {
            sum1 += num;
        }
        double sum2 = 0;
        for (int num : arr2) {
            sum2 += num;
        }
        // 平均值相同就没有magic操作
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        // 确定较大集合和较小集合
        int[] more;
        int[] less;
        double sumMore;
        double sumLess;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            more = arr1;
            sumMore = sum1;
            less = arr2;
            sumLess = sum2;
        } else {
            more = arr2;
            sumMore = sum2;
            less = arr1;
            sumLess = sum1;
        }
        // 较大集合排序，较小集合用set去重登记一下
        Arrays.sort(more);
        HashSet<Integer> setLess = new HashSet<>();
        for (int num : less) {
            setLess.add(num);
        }
        int moreSize = more.length;// 平均值较大的还剩几个数
        int lessSize = less.length;// 平均值较小的还剩几个数
        int ops = 0;
        for (int num : more) {
            double cur = num;
            // 规则：小的平均值<cur<大的平均值，且较小集合不包含cur
            if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize) && !setLess.contains(num)) {
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(num);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double sum, int size) {
        return sum / (double) (size);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5};
        int[] arr2 = {2, 3, 4, 5, 6};
        System.out.println(maxOps(arr1, arr2));

    }

}
