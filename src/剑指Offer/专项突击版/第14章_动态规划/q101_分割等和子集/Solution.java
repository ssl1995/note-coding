package 剑指Offer.专项突击版.第14章_动态规划.q101_分割等和子集;

/**
 * @author SongShengLin
 * @date 2021/11/22 9:47 下午
 * @description
 */
public class Solution {
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
        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];
        return helper(nums, dp, nums.length, target);
    }

    private boolean helper(int[] nums, Boolean[][] dp, int i, int j) {
        if (dp[i][j] == null) {
            if (j == 0) {// j=0表示背包容量为0，不论有多少个物品，都不选择物品放入背包，为true
                dp[i][j] = true;
            } else if (i == 0) {// i=0,没有物品放入背包，为false
                dp[i][j] = false;
            } else {
                dp[i][j] = helper(nums, dp, i - 1, j);
                // 如果前一个物品不让放入背包，且剩余背包数量大于前一个背包数量，就
                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = helper(nums, dp, i - 1, j - nums[i - 1]);
                }
            }
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Solution solution = new Solution();
        boolean res = solution.canPartition(nums);
        System.out.println(res);
    }

}
