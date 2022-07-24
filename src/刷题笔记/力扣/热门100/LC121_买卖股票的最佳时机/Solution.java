package 刷题笔记.力扣.热门100.LC121_买卖股票的最佳时机;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/15 2:56 PM
 * @Describe:
 */
public class Solution {

    /**
     * 买卖股票的最佳时机
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     */
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        // min初始化为第一个元素
        int min = prices[0];
        int max = 0;

        for (int price : prices) {
            min = Math.min(min, price);

            max = Math.max(max, price - min);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(nums));
    }
}
