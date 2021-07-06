package 剑指Offer.剑指Offer49_丑数;

public class Solution {

    // 返回第n个丑数,丑数是只含2,3,5的因数
    public int nthUglyNumber(int n) {
        // 初始化:三个指针,a指向2倍数,b指向3倍数,c指向5倍数
        int a = 0, b = 0, c = 0;
        // dp[i]表示第i+1个丑数
        int[] dp = new int[n];
        // 初始化dp:dp[0]=1,第一个丑数是1
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 公式:dp[i]=min{dp[a-1]*2,dp[b-1]*3,dp[c-1]*5}
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            // 接下来移动指针
            // dp[a-1]*2<=dp[i]<dp[a]*2
            if (dp[i] == n1) {
                a++;
            }
            // dp[b-1]*3<=dp[i]<dp[b]*3
            if (dp[i] == n2) {
                b++;
            }
            // dp[c-1]*5<=dp[i]<dp[c]*5
            if (dp[i] == n3) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
