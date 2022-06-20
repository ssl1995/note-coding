package 刷题笔记.力扣.热门100.LC322_零钱兑换;

/**
 * @author SongShengLin
 * @date 2022/6/20 23:07
 * @description
 */
public class Solution {

    /**
     * 零钱兑换
     */
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
                    // i-coin位置最小值，然后再加一张coin，所以+1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
