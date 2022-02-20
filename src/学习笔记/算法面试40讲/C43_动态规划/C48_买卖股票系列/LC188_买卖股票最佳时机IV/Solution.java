package 学习笔记.算法面试40讲.C43_动态规划.C48_买卖股票系列.LC188_买卖股票最佳时机IV;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/2/20 10:04 AM
 * @description
 */
public class Solution {

    /**
     * 买卖股票的最佳时机IV
     * 注意：'最多'可以完成k笔交易
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // n天最多进行n/2笔交易
        // k取交易数最小值即可
        k = Math.min(k, n / 2);
        // buy[i][j]:持有股票下，到第i天交易j次的最大利润
        int[][] buy = new int[n][k + 1];
        // sell[i][j]:不持有股票下，到第i天交易j次的最大利润
        int[][] sell = new int[n][k + 1];

        // 初始化
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            // /2防止Integer.Min减数时越界
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        // 动态转移
        for (int i = 1; i < n; i++) {
            // 更新第i天，进行0次交易的最大利润
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                // buy[i - 1][j - 1]
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        // 最大利润一定是sell中的最大值
        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 2;
        int[] nums = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.maxProfit(k, nums));
    }
}
