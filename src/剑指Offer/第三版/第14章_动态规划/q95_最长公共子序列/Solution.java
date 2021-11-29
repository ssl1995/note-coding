package 剑指Offer.第三版.第14章_动态规划.q95_最长公共子序列;

/**
 * @author SongShengLin
 * @date 2021/11/17 11:42 下午
 * @description
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // 由于条件转移设计(i-1,j-1),所以长度设+1
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[len1][len2];
    }
}
