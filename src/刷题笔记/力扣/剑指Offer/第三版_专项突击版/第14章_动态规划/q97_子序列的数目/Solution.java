package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第14章_动态规划.q97_子序列的数目;

/**
 * @author SongShengLin
 * @date 2021/11/18 11:51 下午
 * @description
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[i + 1][0] = 1;

            for (int j = 0; i >= j && j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
