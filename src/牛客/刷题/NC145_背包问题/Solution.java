package 牛客.刷题.NC145_背包问题;

public class Solution {
    // 二维dp
    public int knapsack(int V, int n, int[][] vw) {
        // dp[i][j]:前i个物品，背包容量为j时，可以装下的最大价值
        int[][] dp = new int[n + 1][V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if (j < vw[i - 1][0]) {// 当前容量小于第i件物品，只能不拿
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果选择拿了该物品，就要比较谁大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[n][V];
    }

    // 一维dp：将二维dp压缩空间
    public int knapsack1(int V, int n, int[][] vw) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= 1; j--) {// 倒着更新
                if (j >= vw[i - 1][0]) {
                    dp[j] = Math.max(dp[j], dp[j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[V];
    }
}
