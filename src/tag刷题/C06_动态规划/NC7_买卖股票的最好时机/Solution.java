package tag刷题.C06_动态规划.NC7_买卖股票的最好时机;

public class Solution {
    // 暴力递归，缺点是会超时
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // 卖出价格>买入价格,才能算收益
                // 这里就会发现一个规律:从后往前找最小值作为买入的价格
                if (prices[j] > prices[i]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    // 暴力递归推出另一种解法：从后往前找最小买入价格
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 数组中的最小值就是最佳的买入时机
            minPrice = Math.min(minPrice, prices[i]);
            // 最大利润就是当天卖出的价格-最佳买入时间中的最大值
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    // 将上面方法改成动态规划
    public int maxProfit3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // dp[i]记录来到第i+1天的最大利润
        int[] dp = new int[n];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            // 第i+1天的最大利润：第i天的最大利润，今天卖出-最佳买入时机中的最大值
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[n - 1];
    }

}
