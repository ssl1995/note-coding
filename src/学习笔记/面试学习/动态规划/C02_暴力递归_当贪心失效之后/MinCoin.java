package 学习笔记.面试学习.动态规划.C02_暴力递归_当贪心失效之后;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/28 11:49 AM
 * @Describe:
 */
public class MinCoin {

    /**
     * 最少硬币数
     * 递归法=暴力枚举，弊端是出现重复子问题
     */
    public static int getMinCoinCount(int[] values, int target) {
        if (target == 0) {
            return 0;
        }
        // minCount：当前需要的最小数量，初始化为整型最小值
        int minCount = Integer.MAX_VALUE;

        for (int value : values) {
            // 当前面额大，就跳过本次循环
            if (value > target) {
                continue;
            }

            int restTarget = target - value;
            // 递归
            int restCount = getMinCoinCount(values, restTarget);

            if (restCount == -1) {
                continue;
            }

            int curCount = restCount + 1;
            if (curCount < minCount) {
                minCount = curCount;
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }

        return minCount;
    }

    public static void main(String[] args) {
        int[] values = {3, 5};
        int total = 11;
        System.out.println(getMinCoinCount(values, total));
    }

}
