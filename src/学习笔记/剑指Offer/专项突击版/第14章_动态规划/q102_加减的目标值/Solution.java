package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q102_加减的目标值;

/**
 * @author SongShengLin
 * @date 2021/11/23 8:56 上午
 * @description
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int t) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 假设加+号数字和为p，加-号数字和为q
        // 有 p+q=sum，p-q=t,推出p=(t+sum)/2
        // 失败情况
        if ((t + sum) % 2 == 1 || sum < t) {
            return 0;
        }

        return subSetSum(nums, (t + sum) / 2);
    }

    private int subSetSum(int[] nums, int t) {
        // dp[i]表示需要选出数字和为i的方法数量
        int[] dp = new int[t + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = t; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[t];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 2};
        int t = 2;
        int i = solution.subSetSum(nums, t);
        System.out.println(i);
    }


}
