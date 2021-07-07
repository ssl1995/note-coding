package 程序员代码面试指南.第8章_数组和矩阵问题.矩阵的最小路径和;

// 力扣64，相同
public class MinPathSum {
    public int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        // 1.先写出第一行的最小路径和
        for (int i = 1; i < row; i++) {
            // 上元素的路径和+当前元素的数据
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }
        // 2.一般情况，上一步的最下值+当前数据
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        // 3.返回数组末尾
        return dp[row - 1][col - 1];
    }

}
