package 刷题笔记.力扣.热门100.LC416_分割等和子集;

public class Solution {
    /**
     * 分割等和子集
     * 将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     */
    public boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }
        // 等和子集,数组元素和必须为偶数，否则返回false
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int len = nums.length;
        int target = sum / 2;
        // dp[i][j]:表示在nums[0到i]选择一个正整数，只能用一次，是否能形成j
        boolean[][] dp = new boolean[len][target + 1];

        // 初始化：先填写第0行：第一个数只能让恰好等于它的背包装满
        // j-nums[i]>=0保证下标不越界
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                // nums[i]刚好可以组成j
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    // dp[i - 1][j]:不选择nums[i]
                    // dp[i - 1][j - nums[i]]:选择nums[i]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[len - 1][target];
    }
}