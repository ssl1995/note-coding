package 学习笔记.算法面试40讲.C43_动态规划.C48_买卖股票系列.LC121_买卖股票最佳时机I;

/**
 * @author SongShengLin
 * @date 2022/2/17 11:25 PM
 * @description
 */
public class Solution {

    /**
     * LC122_买卖股票最佳时机I
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     */
    public int maxProfit(int[] prices) {
        // 找出买卖一只股票获得最大利润
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
