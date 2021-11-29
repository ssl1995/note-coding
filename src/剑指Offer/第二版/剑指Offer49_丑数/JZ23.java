package 剑指Offer.第二版.剑指Offer49_丑数;

public class JZ23 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
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
        return dp[index - 1];
    }
}
