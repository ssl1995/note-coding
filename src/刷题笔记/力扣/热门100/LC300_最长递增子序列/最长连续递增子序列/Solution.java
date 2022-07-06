package 刷题笔记.力扣.热门100.LC300_最长递增子序列.最长连续递增子序列;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/7/4 09:49
 * @description
 */
public class Solution {

    /**
     * 最长连续递增子序列
     * 输入: nums = [1, 3, 5, 0, 7]
     * 输出: 3
     * 解释: 最长连续递增序列是 [1, 3, 5], 长度为 3。
     * 你会发现 [1, 3, 5, 7] 也是升序的子序列,
     * 但它不是连续的。因为 5 和 7 在原数组中被 0 隔开。因此，这不是原问题的答案。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i]：[0..i]组成的最长子序列长度，初始化为1
        int[] dp = new int[nums.length];
        // 初试化：最长连续子序列长度最低为1
        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;

                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
