package tag刷题.C06_动态规划.剑指Offer47_礼物的最大值;

public class Solution {
    // 动态规划:最容易理解的写法
    public int maxValue1(int[][] grid) {
        // 初始化dp数组,长度为dp[m][n]
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // 显然基础状态值:grid[0][0]
        dp[0][0] = grid[0][0];
        // 通用状态转移:dp[i][j]=Max{dp[i-1][j],dp[i][j-1]}+grid[i][j]
        // 但是存在3种特殊情况:dp[0][0]、第一行、第一列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {// 特殊情况:遇到原点dp[0][0]就跳过
                    continue;
                } else if (i == 0) {// 特殊情况:遇到第一行
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {// 特殊情况:遇到第一列
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {// 通用状态转移:dp[i][j]=Max{dp[i-1][j],dp[i][j-1]}+grid[i][j]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // 动态规划:高效写法,缺点是改变了原数组
    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 特殊情况:遇到第一列,先初始化
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // 特殊情况:遇到第一行,先初始化
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // 从[1][1]开始通用状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
