package 学习笔记.算法面试40讲.C43_动态规划.C50_零钱兑换.LC322_零钱兑换;

/**
 * @author SongShengLin
 * @date 2022/2/20 1:09 PM
 * @description
 */
public class Solution {
    /**
     * 零钱兑换
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
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
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int target = 11;
        System.out.println(solution.coinChange(coins, target));
    }
}
