package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第14章_动态规划.q101_分割等和子集;

/**
 * @author SongShengLin
 * @date 2021/11/22 9:47 下午
 * @description
 */
public class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return subSetSum(nums, sum / 2);
    }

    private boolean subSetSum(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Solution1 solution = new Solution1();
        boolean res = solution.canPartition(nums);
        System.out.println(res);
    }

}
