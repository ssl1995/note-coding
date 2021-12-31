package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q98_路径的数目;

/**
 * @author SongShengLin
 * @date 2021/11/20 10:45 下午
 * @description
 */
public class Solution1 {

    public int uniquePaths(int m, int n) {
        // dp[i][j]表示从0点到该坐标的路径数
        int[][] dp = new int[m][n];
        // 初始化第一行和第一列，只有一种路径到达
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.uniquePaths(3, 3));
    }
}
