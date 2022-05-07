package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q63_股票的最大利润;

public class Solution {

    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 买入价从第一个数开始尝试
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 固定卖出价=prices[i],买入价minPrice越低,利润越大
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
