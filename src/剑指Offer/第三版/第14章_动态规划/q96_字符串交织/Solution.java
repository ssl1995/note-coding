package 剑指Offer.第三版.第14章_动态规划.q96_字符串交织;

/**
 * @author SongShengLin
 * @date 2021/11/18 9:16 上午
 * @description
 */
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        // 两个空字符能拼接成任何字符
        dp[0][0] = true;

        // 初始化行列
        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i + 1] = s2.charAt(i) == s3.charAt(i) && dp[0][i];
        }

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                char c3 = s3.charAt(i + j + 1);
                // 动态转移方程
                dp[i + 1][j + 1] = (c1 == c3 && dp[i][j + 1]) || (c2 == c3 && dp[i + 1][j]);
            }
        }

        return dp[s1.length()][s2.length()];
    }


}
