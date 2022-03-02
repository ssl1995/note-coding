package 刷题笔记.力扣.热门100.LC494_目标和;

/**
 * @author SongShengLin
 * @date 2021/11/23 8:56 上午
 * @description
 */
public class Solution1 {

    /**
     * 目标和
     * 向数组中的每个整数前添加 '+' 或 '-'，构成不同表达式的数量
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     * 限制条件
     * 1 <= nums.length <= 20
     * 0 <= nums[i] <= 1000
     * 0 <= sum(nums[i]) <= 1000
     * -1000 <= target <= 1000
     */
    public int findTargetSumWays(int[] nums, int t) {
        // 假设加+号数字和为p，加-号数字和为q
        // 有 p+q=sum和p-q=t -> p=(t+sum)/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // p=(t+sum)/2，p是数组中元素之和，也是非负整数
        // sum是非负整数之和
        if ((t + sum) % 2 == 1 || sum < t) {
            return 0;
        }

        return subSetSum(nums, (t + sum) / 2);
    }

    private int subSetSum(int[] nums, int t) {
        // dp[i]表示需要选出数字和为i的方法数量
        t = Math.abs(t);
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
        Solution1 solution = new Solution1();
        int[] nums = {2, 2, 2};
        int t = 2;
        int i = solution.subSetSum(nums, t);
        System.out.println(i);
    }


}
