package 剑指Offer.第二版.剑指Offer63_股票的最大利润;

public class Solution {

    // 动态规划
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // dp[i]:表示prices[i]为结尾的数组最大利润
        int[] dp = new int[n];
        // 第一日利润为0,因为一天只能买不能卖
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            // 先计算[0,i]的最小价格作为买入价格
            minPrice = Math.min(minPrice, prices[i]);
            // dp[i]=max(前一日以来的最大利润,第i日的最大利润=当前价格-最小买入价格)
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[n - 1];
    }

    // 高度概括：当日最大利润 = max(当天价格-截止目前的最小价格)
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;// 没有利润，规定为0
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
