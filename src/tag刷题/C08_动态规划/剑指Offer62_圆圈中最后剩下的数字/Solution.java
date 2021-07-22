package tag刷题.C08_动态规划.剑指Offer62_圆圈中最后剩下的数字;

public class Solution {

    // 动态规划:最容易理解的版本
    public int lastRemaining1(int n, int m) {
        int[] dp = new int[n];
        // f(1,m)解恒为0
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            // 动态转移方程:f(n,m)=[f(n-1,m)+m]%n
            // 注意:dp[i]时,数组长度为i+1
            dp[i] = (dp[i - 1] + m) % (i + 1);
        }
        return dp[n - 1];
    }

    // 动态规划:无需开辟dp数组
    public int lastRemaining2(int n, int m) {
        // n代表数组长度,n=长度1时,res=0
        int res = 0;
        for (int i = 2; i <= n; i++) {
            // res = (res +m) % n
            res = (res + m) % i;
        }
        return res;
    }
}
