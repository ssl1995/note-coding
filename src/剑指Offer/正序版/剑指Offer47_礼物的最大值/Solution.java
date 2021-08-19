package 剑指Offer.正序版.剑指Offer47_礼物的最大值;

public class Solution {
    // 动态规划:最容易理解的写法
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j]表示到达grid[i][j]时的礼物最大值
        int[][] dp = new int[m][n];
        // 状态转移:dp[i][j]=Max{dp[i-1][j],dp[i][j-1]}+grid[i][j]
        // 根据状态转移，初始化dp[0][0]、第一行、第一列
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 常规情况
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 左边或上边的最大值+grid[i][j]
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
