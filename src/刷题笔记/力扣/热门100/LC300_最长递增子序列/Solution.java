package 刷题笔记.力扣.热门100.LC300_最长递增子序列;

import java.util.Arrays;

public class Solution {

    /**
     * 最长递增子序列
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i]：[0..i]组成的最长子序列长度，初始化为1
        int[] dp = new int[nums.length];
        // 初试化：最长连续子序列长度最低为1
        Arrays.fill(dp, 1);

        int manLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    // 动态规划
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    manLen = Math.max(dp[i], manLen);
                }
            }
        }
        return manLen;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {10, 9, 2, 5, 3, 7, 101, 18};
        //   tails = {2, 3, 7, 18, 0, 0, 0, 0};
        System.out.println(solution.lengthOfLIS(arr1));
    }
}