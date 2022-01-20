package 刷题笔记.力扣.热门100.LC5_最长回文子串.练习;

/**
 * @author SongShengLin
 * @date 2022/1/19 10:42 PM
 * @description
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] cs = s.toCharArray();
        int n = s.length();
        // dp[i][j]表示s从i到j位置是否是回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int begin = 0;
        int maxLen = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (cs[i] != cs[j]) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] || j - i + 1 <= 3;
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = Math.max(maxLen, j - i + 1);
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
    }
}
