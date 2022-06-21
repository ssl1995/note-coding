package 刷题笔记.力扣.热门100.LC416_分割等和子集;

public class Solution {
    /**
     * 分割等和子集
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     */
    public boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }
        // nums元素和为奇数，不能形成等和子集
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int m = nums.length;
        int n = sum / 2;
        // dp[i][j]:表示0到i选择一个正整数，只能用一次，是否能形成j
        // 每一行只用填写一个数
        boolean[][] dp = new boolean[m][n + 1];

        // 先填写第0行
        if (nums[0] <= n) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                // 先复制上一次的结果
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

        return dp[m-1][n];
    }
}