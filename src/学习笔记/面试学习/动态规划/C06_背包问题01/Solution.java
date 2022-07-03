package 学习笔记.面试学习.动态规划.C06_背包问题01;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/30 9:52 AM
 * @Describe:
 */
public class Solution {


    /**
     * 01背包问题
     * 给你一个可放总重量为 W 的背包和 N 个物品，对每个物品，
     * 有重量 w 和价值 v 两个属性，那么第 i 个物品的重量为 w[i]，价值为 v[i]。
     * 现在让你用这个背包装物品，问最多能装的价值是多少？
     * 示例：
     * 输入：W = 5, N = 3
     * w = [3, 2, 1], v = [5, 2, 3]
     * 输出：8
     * 解释：选择 i=0 和 i=2 这两件物品装进背包。它们的总重量 4 小于 W，
     * 同时可以获得最大价值 8。
     */
    public static int backpack(int w[], int v[], int W, int N) {
        // dp[i][j]:背包为i重量时，放入前j个物品的最大价值
        int[][] dp = new int[W + 1][N + 1];
        // 初试化
        for (int i = 0; i < W + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < N + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < W + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // 背包容量i < 第j件物品重量时，只能看前一个物品重量
                if (i < w[j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // 背包容量i > 第j件物品重量时，就要走出决策：第j件物品是否需要加入背包
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - w[j]][j - 1] + v[j]);
                }
            }
        }

        return dp[W][N];
    }

    public static void main(String[] args) {
        int N = 3, W = 5; // 物品的总数，背包能容纳的总重量
        int[] w = {0, 3, 2, 1}; // 物品的重量
        int[] v = {0, 5, 2, 3}; // 物品的价值

        System.out.println(backpack(w, v, W, N));
    }
}
