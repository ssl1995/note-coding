package 学习笔记.面试学习.动态规划.C04_动态规划;

import java.util.Arrays;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/29 11:08 AM
 * @Describe:
 */
public class MinCoinDp {

    public static int getMinCoin(int[] values, int target) {
        int[] dp = new int[target + 1];
        // 模拟无穷大
        Arrays.fill(dp, target + 1);
        dp[0] = 0;

        for (int i = 1; i < target + 1; i++) {
            for (int value : values) {
                if (value > i) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - value] + 1);
            }
        }

        return dp[target] == target + 1 ? -1 : dp[target];

    }

    public static void main(String[] args) {
        int[] values = {3, 5};
        int target = 11;
        System.out.println(getMinCoin(values, target));
    }
}
