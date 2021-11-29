package 剑指Offer.第三版.第14章_动态规划.q99_最小路径之和;

/**
 * @author SongShengLin
 * @date 2021/11/20 11:11 下午
 * @description
 */
public class Solution2 {

    public int minPathSum(int[][] grid) {
        // 优化成一位数组
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        // 在动态转移的时候，也可以初始化第一列
        for (int i = 1; i < grid.length; i++) {
            // 初始化第一列开头时候要累加
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                // 最小路径和动态转移方程
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }

        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] grid = {{1, 3, 1}, {2, 5, 2}, {3, 4, 1}};
        System.out.println(solution.minPathSum(grid));
    }
}
