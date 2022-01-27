package 刷题笔记.力扣.热门100.LC62_不同路径;

/**
 * @author SongShengLin
 * @date 2022/1/27 8:40 AM
 * @description
 */
public class Solution {
    /**
     * 机器人路径问题
     * 输入：m = 3, n = 7
     * 输出：28
     */
    public int uniquePaths(int m, int n) {
        // 求不同路径,从上/左过来的路径之和就是该位置的不同路径和
        int[][] dp = new int[m][n];
        // 初始化原点、第一行、第一列，自己到自己原地不动算一条路径
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 3, n = 2;
        System.out.println(solution.uniquePaths(m, n));
    }
}
