package tag刷题.C08_动态规划.剑指Offer10_I_斐波拉契数列;

public class Solution {
    // 法1:迭代法
    public int fib1(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        // n=0和n=1,直接返回0和1
        // n=2,走1步;n=3,走2步...n=n时,走n-1步
        for (int i = 0; i < n - 1; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    // 法2:动态规划法
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        // dp[i]表示第i个斐波那契数
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
