package 剑指Offer.专项突击版.第14章_动态规划.q95_最长公共子序列;

/**
 * @author SongShengLin
 * @date 2021/11/17 11:42 下午
 * @description
 */
public class Solution1 {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // 由于f(i,j)只依赖f(i-1,j-1)和f(i-1,j),f(i,j-1)的值，所以可以优化只需要2行的二维数组
        // 列长了，就翻转过来
        if (len1 < len2) {
            return longestCommonSubsequence(text2, text1);
        }

        int[][] dp = new int[2][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                } else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[i % 2][j + 1], dp[(i + 1) % 2][j]);
                }
            }
        }

        return dp[len1 % 2][len2];
    }
}
