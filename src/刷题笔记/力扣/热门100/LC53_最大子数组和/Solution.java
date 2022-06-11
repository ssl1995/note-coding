package 刷题笔记.力扣.热门100.LC53_最大子数组和;

/**
 * @author SongShengLin
 * @date 2022/1/26 8:21 AM
 * @description
 */
public class Solution {

    /**
     * 最大子数组和
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    public int maxSubArray(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? -1 : nums[0];
        }
        // dp[i]:i位置目前的最大子数组和为多少
        int[] dp = new int[nums.length];
        // 0位置初始化
        dp[0] = nums[0];
        // max初始化为dp[0]防止数组只有一个元素没法遍历的情况
        int max = dp[0];
        // 从1位置开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 前面的子数组和为负数，就放弃
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                // 前面的子数组和>0，就加入
                dp[i] = dp[i - 1] + nums[i];
            }
            // 遍历选择其中最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
}
