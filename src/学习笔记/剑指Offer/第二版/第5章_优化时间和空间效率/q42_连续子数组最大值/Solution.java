package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q42_连续子数组最大值;

public class Solution {
    /**
     * 求一个数组中，数组中一个或多个连续整数组组成一个子数组，求所有子数组和的最大值
     * 数组长度>=1
     * 动态规划法
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 题目：连续整数，提示我们用动态规划
        // 初始化dp:dp[i]表示nums中前i个元素的最大和
        int[] dp = new int[nums.length];
        // 根据动态转移dp[i]与dp[i-1]有关，思考初始化dp[0]
        dp[0] = nums[0];
        // 初始化max=nums[0],千万别是0或者整型最小值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 前i-1元素的最大和<=0,产生负影响,舍弃
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {// 前i-1元素的最大和>0,产生正影响
                dp[i] = dp[i - 1] + nums[i];
            }
            // 更新最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(arr));
    }
}
