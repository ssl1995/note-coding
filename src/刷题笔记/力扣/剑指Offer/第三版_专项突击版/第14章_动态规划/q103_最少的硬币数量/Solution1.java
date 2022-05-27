package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第14章_动态规划.q103_最少的硬币数量;

/**
 * @author SongShengLin
 * @date 2021/11/23 9:30 上午
 * @description
 */
public class Solution1 {
    // coins是正整数
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        // dp[i]=选出总额为i的最少硬币数
        int[] dp = new int[amount + 1];
        // 遍历[1,amount],因为金额从1到amount
        for (int i = 1; i <= amount; i++) {
            // 预设失败值
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
