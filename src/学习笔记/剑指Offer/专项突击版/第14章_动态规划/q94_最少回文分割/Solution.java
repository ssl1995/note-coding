package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q94_最少回文分割;

/**
 * @author SongShengLin
 * @date 2021/11/17 12:41 上午
 * @description
 */
public class Solution {

    public int minCut(String s) {
        int len = s.length();
        // isPal[j][i]=判断s(j,i)是否是回文
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(j);
                if (c1 == c2 && ((i - j + 1 <= 2) || (isPal[j + 1][i - 1]))) {
                    isPal[j][i] = true;
                }
            }
        }
        // dp[i]:s(0,i)的最少回文次数。dp[i]=min(dp[i-1])+1;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                // s(0,i)不是回文，dp最大分割次数就是当前坐标
                dp[i] = i;
                // s(0,i)的最少回文分割有s(0,i-1)中的最小值+1决定
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
