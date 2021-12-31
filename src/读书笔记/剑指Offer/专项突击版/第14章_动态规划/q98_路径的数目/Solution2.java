package 读书笔记.剑指Offer.专项突击版.第14章_动态规划.q98_路径的数目;

/**
 * @author SongShengLin
 * @date 2021/11/20 10:45 下午
 * @description
 */
public class Solution2 {

    public int uniquePaths(int m, int n) {
        // 优化空间，只用一维数组
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.uniquePaths(3, 3));
    }
}
