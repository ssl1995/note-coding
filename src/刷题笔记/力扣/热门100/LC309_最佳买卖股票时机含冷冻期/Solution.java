package 刷题笔记.力扣.热门100.LC309_最佳买卖股票时机含冷冻期;

/**
 * @author SongShengLin
 * @date 2022/2/23 4:54 PM
 * @description
 */
public class Solution {
    /**
     * 最佳买卖股票时机含冷冻期
     * 输入: prices = [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // dp[i][j]：第i天最大利润
        // 当来到i天，会有以下3种状态，所以是二维数组
        // j=0说明第i天持有股票
        // j=1说明第i天不持有股票，处于冷冻期
        // j=2说明第i天不持有股票，不处于冷冻期
        int[][] dp = new int[n][3];
        // 初始化
        // 第0天持有股票：属于买股票
        dp[0][0] = -prices[0];
        // 第0天不持有股票，但处于冷冻期，不存在，假设为0
        dp[0][1] = 0;
        // 第0天不持有股票，不处于冷冻期，不存在，假设为0
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            // 第i天持有股票最大利润：前一天持有股票的情况延续至今；前一天没有股票且不处于冷冻期
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            // 第i天不持有股票最大利润，但处于冷冻期：前一天有股票，今天卖出
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 第i天不持有股票最大利润，不处于冷冻期：今天没有任何操作，取前一天不持有股票两种状态最大值
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1};
        System.out.println(solution.maxProfit(nums));
    }
}
