package 剑指Offer.第三版.第14章_动态规划.q101_分割等和子集;

/**
 * @author SongShengLin
 * @date 2021/11/22 9:47 下午
 * @description
 */
public class Solution2 {
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
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (!dp[j] && j >= nums[i - 1]) {
                    dp[j] = dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Solution2 solution = new Solution2();
        boolean res = solution.canPartition(nums);
        System.out.println(res);
    }

}
