package 学习笔记.算法面试40讲.C43_动态规划.C49_最长递增子序列.LC300_最长递增子序列;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/2/20 11:49 AM
 * @description
 */
public class Solution {
    /**
     * 最长递增子序列
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            // 从[j,i]计算到i时的最长递增子序列长度
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums));
    }

}
