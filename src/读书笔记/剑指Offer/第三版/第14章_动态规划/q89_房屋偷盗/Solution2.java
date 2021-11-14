package 读书笔记.剑指Offer.第三版.第14章_动态规划.q89_房屋偷盗;

/**
 * @author SongShengLin
 * @date 2021/11/14 4:59 下午
 * @description
 */
public class Solution2 {
    // 自下而上优化空间复杂度，dp
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = nums[0];

        if (len > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < len; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);
        }
        return dp[(nums.length - 1) % 2];
    }
}
