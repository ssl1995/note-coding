package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第14章_动态规划.q89_房屋偷盗;

/**
 * @author SongShengLin
 * @date 2021/11/14 5:17 下午
 * @description
 */
public class Solution1 {
    // 自下而上，记忆化缓存dp
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
