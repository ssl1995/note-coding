package 学习笔记.算法面试40讲.C43_动态规划.C48_买卖股票系列.LC309_最佳买卖股票时机含冷冻期;

/**
 * @author SongShengLin
 * @date 2022/2/23 4:54 PM
 * @description
 */
public class Solution1 {
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
        // dp[i][j]：第i天最大利润，
        // j=0说明第i天持有股票
        // j=1说明第i天不持有股票，处于冷冻期
        // j=2说明第i天不持有股票，不处于冷冻期
        // dp空间优化
        int n0 = -prices[0];
        int n1 = 0;
        int n2 = 0;

        for (int i = 1; i < n; i++) {
            int a = Math.max(n2 - prices[i], n0);
            int b = n0 + prices[i];
            int c = Math.max(n1, n2);

            n0 = a;
            n1 = b;
            n2 = c;
        }
        return Math.max(n1, n2);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {2, 1};
        System.out.println(solution.maxProfit(nums));
    }
}
