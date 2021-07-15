package 剑指Offer.分类版.C08_动态规划.剑指Offer10_II_青蛙跳台阶;

public class Solution {

    // 法1:迭代法
    public int numWays1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    // 法2:动态规划法
    public int numWays2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // dp[i]表示第i个斐波那契数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
