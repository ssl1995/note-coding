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

        for (int i = 1; i <= n; i++) {
            // 最多情况：i=4,需要4个1相加
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12;
        // dp=[0, 1, 2, 3, 1, 2, 3, 4, 2, 1, 2, 3, 3]
        System.out.println(solution.numSquares(n));
    }
}

