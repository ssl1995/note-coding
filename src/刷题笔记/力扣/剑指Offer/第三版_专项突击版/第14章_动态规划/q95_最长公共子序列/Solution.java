package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第14章_动态规划.q95_最长公共子序列;

/**
 * @author SongShengLin
 * @date 2021/11/17 11:42 下午
 * @description
 */
public class Solution {

    /**
     * 最长公共子序列
     * 输入：text1 = "abcde", text2 = "ade"输出：3
     * 解释：最长公共子序列是 "ade"，它的长度为 3。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // dp[i][j] 表示的是 text1[0…i-1] 和 text2[0…j-1] 的最长公共子序列的长度。
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abcde";
        String s2 = "ade";
        System.out.println(solution.longestCommonSubsequence(s1, s2));
    }
}
