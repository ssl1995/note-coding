package 学习笔记.算法面试40讲.C25_买卖股票最佳时机.LC122_买卖股票最佳时机II;

/**
 * @author SongShengLin
 * @date 2022/2/17 11:25 PM
 * @description
 */
public class Solution2 {

    /**
     * LC122_买卖股票最佳时机II
     * 输入: prices = [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 优化Dp，不需要二维数组
        int notBuy = 0;
        int buy;

        int preNotBuy = 0;
        int preBuy = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            notBuy = Math.max(preNotBuy, preBuy + prices[i]);
            buy = Math.max(preBuy, preNotBuy - prices[i]);

            preNotBuy = notBuy;
            preBuy = buy;
        }

        return notBuy;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(nums));
    }
}
