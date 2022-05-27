package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第14章_动态规划.q98_路径的数目;

/**
 * @author SongShengLin
 * @date 2021/11/20 10:45 下午
 * @description
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        // dp[i][j]表示从0点到该坐标的路径数
        int[][] dp = new int[m][n];
        // 从右下角反推出结果
        return helper(m - 1, n - 1, dp);
    }

    private int helper(int i, int j, int[][] dp) {
        if (dp[i][j] == 0) {
            // 第一行or第一列只有一种路径到达
            if (i == 0 || j == 0) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = helper(i - 1, j, dp) + helper(i, j - 1, dp);
            }
        }
        // 不为0,说明之前缓存过结果，直接取出即可
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 3));
    }
}
