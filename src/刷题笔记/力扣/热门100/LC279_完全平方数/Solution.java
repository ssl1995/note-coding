package 刷题笔记.力扣.热门100.LC279_完全平方数;

/**
 * @author SongShengLin
 * @date 2022/2/22 11:19 PM
 * @description
 */
public class Solution {
    /**
     * 完全平方数
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     */
    public int numSquares(int n) {
        // dp[i]:表示构成整数i最少需要多少个完全平方数
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 完全平方数:[1,根号i]里，枚举这些数，假设为j
            for (int j = 1; j * j <= i; j++) {
                // 选取一个数后，剩下的数是i-j^2
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12;
        System.out.println(solution.numSquares(n));
    }
}

