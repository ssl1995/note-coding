package 读书笔记.剑指Offer.第三版.第14章_动态规划.q103_最少的硬币数量;

/**
 * @author SongShengLin
 * @date 2021/11/23 9:30 上午
 * @description
 */
public class Solution1 {
    // coins是正整数
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示凑出总额为i的最少硬币数
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // 预设失败的硬币数量
            dp[i] = amount + 1;
            for (int coin : coins) {
                // 总额i>=硬币面额，才循环
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
