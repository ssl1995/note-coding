package tag刷题.C06_动态规划.剑指Offer10_II_青蛙跳台阶;

public class Solution {

    // 法1:迭代法，0<=n<=100
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

    // 法2:动态规划法,0<=n<=100,首推动态规划法
    public int numWays2(int n) {
        // n从0开始，与牛客68题区别1
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;// 坐标0-第一个台阶
        dp[1] = 2;// 坐标1-第二个台阶
        for (int i = 2; i < n; i++) {
            // 需要取模1000000007，与牛客68题区别2
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n - 1];
    }
}
