package 读书笔记.剑指Offer.第三版.第14章_动态规划.q104_排列的数目;

/**
 * @author SongShengLin
 * @date 2021/11/23 12:44 下午
 * @description
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp[i]表示和为i的排列数目
        int[] dp = new int[target + 1];
        // 初始化：空排列数字之和为0
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 3;
        Solution solution = new Solution();
        int res = solution.combinationSum4(nums, target);
        System.out.println(res);
    }
}
