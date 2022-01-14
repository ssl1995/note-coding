package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q49_丑数.练习;

/**
 * @author SongShengLin
 * @date 2022/1/14 9:17 AM
 * @description
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int min;
        for (int i = 1; i < n; i++) {
            int num1 = dp[a] * 2;
            int num2 = dp[b] * 3;
            int num3 = dp[c] * 5;
            min = Math.min(Math.min(num1, num2), num3);
            if (num1 == min) {
                a++;
            }
            if (num2 == min) {
                b++;
            }
            if (num3 == min) {
                c++;
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        System.out.println(solution.nthUglyNumber(n));
    }
}
