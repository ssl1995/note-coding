package tag刷题.C08_动态规划.剑指Offer42_连续子数组最大值;

public class Solution {
    // 动态规划法:最容易理解的写法
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 初始化dp:dp[i]表示nums中前i个元素的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];// 第0个元素的最大和为它本身
        // 初始化最大和的最大值=nums[0],千万别是0或者整型最小值
        int max = nums[0];
        // 从第二个数开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 前i-1元素的最大和<=0,产生负影响,舍弃
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {// 前i-1元素的最大和<=0,产生正影响
                dp[i] = dp[i - 1] + nums[i];
            }
            // 更新最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 动态规划法:最简便的写法,缺点是修改了原数组,只能适合刷题
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= 0) {
                nums[i] = nums[i];
            } else {
                nums[i] = nums[i] + nums[i - 1];
            }
            // 以上语句可用这个替代:nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
