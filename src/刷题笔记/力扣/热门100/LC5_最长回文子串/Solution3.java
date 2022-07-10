package 刷题笔记.力扣.热门100.LC5_最长回文子串;


public class Solution3 {
    /**
     * 最长回文子串
     * 动态规划法:面试选这个解法
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        // [j...i]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = i - j + 1 <= 3 || dp[j + 1][i - 1];
                } else {
                    dp[j][i] = false;
                }

                if (dp[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    // 内层循环时j，初始位置是j
                    begin = j;
                }
            }
        }
        // substring第二个参数是begin+len;不是len
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "babad";
        System.out.println(solution3.longestPalindrome(s));
    }

}
