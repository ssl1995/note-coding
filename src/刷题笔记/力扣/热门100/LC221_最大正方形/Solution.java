package 刷题笔记.力扣.热门100.LC221_最大正方形;

/**
 * @author SongShengLin
 * @date 2022/2/22 8:55 PM
 * @description
 */
public class Solution {
    /**
     * 最大正方形：
     * 求1组成正方形最大面积
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
        // 存dp中的最大值
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // ==0,跳到下个循环
                if (matrix[i][j] == '0') {
                    continue;
                }
                // =='1'
                if (i == 0 || j == 0) {
                    // 边长：=1
                    dp[i][j] = 1;
                } else {
                    // 边长：取三个方向的最小值+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }

                // 记录其中最大值
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] nums = {
                {'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }};

    }
}
