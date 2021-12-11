package 剑指Offer.第二版.第2章_面试需要的基础知识.q14_剪绳子I;

/**
 * @author SongShengLin
 * @date 2021/12/11 11:44 PM
 * @description
 */
public class Solution {
    /**
     * 就n划分为m段(m,n均>1),求划分成m段后，各段乘积最大值
     * n的取值范围：2 <= n <= 58
     */
    public int cuttingRope(int n) {
        // n=1，2，3，划为至少2段，乘积最大值为1，1，2
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // 动态规划法：i从4开始，dp[i]:把i划分为m段后的，乘积的最大值
        int[] dp = new int[n + 1];
        // i从4开始，初始化前3段存n的长度≠存前3段乘积最大值
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            // dp[i]=max(dp[j],dp[i-j])
            for (int j = 1; j <= (i / 2); j++) {
                int temp = dp[j] * dp[i - j];
                max = Math.max(max, temp);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(4));
        System.out.println(solution.cuttingRope(5));
        System.out.println(solution.cuttingRope(6));
    }

}
