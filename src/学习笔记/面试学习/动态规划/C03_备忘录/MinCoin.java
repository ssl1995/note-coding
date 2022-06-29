package 学习笔记.面试学习.动态规划.C03_备忘录;

import java.util.Arrays;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/29 10:09 AM
 * @Describe:
 */
public class MinCoin {

    /**
     * 最小硬币数
     * 暴力递归，使用备忘录自顶向下
     */
    public static int getMinCoinCount(int[] values, int target, int[] memo) {
        // 备忘录memo[x]=-2，表示该元素没有被缓存过；!=-2，表示缓存过
        if (memo[target] != -2) {
            return memo[target];
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
            int restCount = getMinCoinCount(values, restTarget, memo);

            if (restCount == -1) {
                continue;
            }

            int curCount = restCount + 1;
            if (curCount < minCount) {
                minCount = curCount;
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            // 记录到备忘录
            memo[target] = -1;
            return -1;
        }
        // 记录到备忘录
        memo[target] = minCount;
        return minCount;
    }

    public static void main(String[] args) {
        int[] values = {3, 5};
        int total = 11;

        int[] memo = new int[total + 1];
        // 先fill再设置[0]=0
        Arrays.fill(memo, -2);
        memo[0] = 0;
        // 没有缓存过的元素初始化全为-2

        System.out.println(getMinCoinCount(values, total, memo));
    }

}
