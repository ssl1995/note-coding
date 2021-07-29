package tag刷题.C06_动态规划.NC7_买卖股票的最好时机;

public class Solution {
    // 暴力递归
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

    // 另一种动态规划：设两种状态，未持有股票和持有股票
    public int maxProfit4(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // dp[i][0]表示第i+1天没持有股票的利润最大值
        // dp[i][1]表示第i+1天持有股票的利润最大值
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;// 第一天没持有股票最大值0
        dp[0][1] = -prices[0];// 第一天持有股票最大值-prices[0].因为第一天只能买股票=花出去
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                // 第i+1天未持有股票的最大利润：max(第i天未持有的最大利润，第i天持有的利润+今天卖出的价格)
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 第i+1天持有股票的最大利润：(第i天持有的最大利润，今天买入股票的支出)
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        // 最大利润=最后一天未持有股票的最大利润(因为都卖出去了)
        return dp[n - 1][0];
    }

    // 将上面动态规划改成不需要dp数组
    public int maxProfit5(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int noHold = 0;// 第1天未持有股票的利润最大值
        int hold = -prices[0];// 第1天持有股票的利润最大值
        for (int i = 1; i < prices.length; i++) {
            // 第i+1天未持有股票的最大利润：max(第i天未持有的最大利润，第i天持有的利润+今天卖出的价格)
            noHold = Math.max(noHold, hold + prices[i]);
            // 第i+1天持有股票的最大利润：(第i天持有的最大利润，今天买入股票的支出)
            hold = Math.max(hold, -prices[i]);
        }
        // 最大利润=最后一天未持有股票的最大利润(因为都卖出去了)
        return noHold;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit1(prices));
        System.out.println(solution.maxProfit2(prices));
        System.out.println(solution.maxProfit3(prices));
        System.out.println(solution.maxProfit4(prices));
        System.out.println(solution.maxProfit5(prices));
    }
}
