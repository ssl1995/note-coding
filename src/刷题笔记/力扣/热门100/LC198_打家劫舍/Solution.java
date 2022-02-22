package 刷题笔记.力扣.热门100.LC198_打家劫舍;

/**
 * @author SongShengLin
 * @date 2022/2/22 7:44 AM
 * @description
 */
public class Solution {
    /**
     * 打家劫舍
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // dp[i]:表示从0到i号房间能偷盗的最大值
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(solution.rob(nums));
    }
}
