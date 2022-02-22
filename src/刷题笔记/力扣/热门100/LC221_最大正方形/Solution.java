package 刷题笔记.力扣.热门100.LC221_最大正方形;

/**
 * @author SongShengLin
 * @date 2022/2/22 8:55 PM
 * @description
 */
public class Solution {
    /**
     * 求最大正方形输入：
     * matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：4
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j]:表示(i,j)位置构成最大正方形的边长
        int[][] dp = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                // =='1'才更新dp
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // 面积取最小值，因为大的值不一定在该位置构成正方形
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                // 边长取最大值
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
