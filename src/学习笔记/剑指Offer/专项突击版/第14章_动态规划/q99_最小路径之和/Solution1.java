package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q99_最小路径之和;

/**
 * @author SongShengLin
 * @date 2021/11/20 11:11 下午
 * @description
 */
public class Solution1 {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[2][grid[0].length];
        dp[0][0] = grid[0][0];
        // 初始化第一行
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 在动态转移的时候，也可以初始化第一列
        for (int i = 1; i < grid.length; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                // 最小路径和动态转移方程
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j];
            }
        }

        return dp[(grid.length - 1) % 2][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[][] grid = {{1, 3, 1}, {2, 5, 2}, {3, 4, 1}};
        System.out.println(solution.minPathSum(grid));
    }
}
