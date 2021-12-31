package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q103_最少的硬币数量;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2021/11/23 9:30 上午
 * @description
 */
public class Solution {
    // coins是正整数
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // amount + 1表示某个面额不能用输入的硬币凑出
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = amount; j >= 1; j--) {
                for (int k = 1; k * coin <= j; k++) {
                    dp[j] = Math.min(dp[j], dp[j - k * coin] + k);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
