package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q89_房屋偷盗;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2021/11/14 5:17 下午
 * @description
 */
public class Solution {

    // 从上往下，记忆化缓存dp
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        helper(nums, nums.length - 1, dp);

        return dp[nums.length - 1];
    }

    private void helper(int[] nums, int i, int[] dp) {
        if (i == 0) {
            dp[i] = nums[0];
        } else if (i == 1) {
            dp[i] = Math.max(nums[0], nums[1]);
        } else if (dp[i] < 0) {
            helper(nums, i - 2, dp);
            helper(nums, i - 1, dp);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
    }

}
