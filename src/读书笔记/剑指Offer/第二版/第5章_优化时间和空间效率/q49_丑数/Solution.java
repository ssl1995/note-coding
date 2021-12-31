package 读书笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q49_丑数;

public class Solution {

    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     */
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        // 初始化:三个指针,a指向2倍数,b指向3倍数,c指向5倍数
        int a = 0, b = 0, c = 0;
        // dp[i]表示第i+1个丑数
        int[] dp = new int[n];
        // 初始化dp:dp[0]=1,第一个丑数是1
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 公式:dp[i]=min{dp[a]*2,dp[b]*3,dp[c]*5}
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            // 接下来移动指针,哪个指针被选中作为该论的丑数，谁就后移一位
            if (dp[i] == n1) {
                a++;
            }
            if (dp[i] == n2) {
                b++;
            }
            if (dp[i] == n3) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
