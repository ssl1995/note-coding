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
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();
        // dp[i][j]:表示s从i..j位置是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：对角线上单独一个字符肯定是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 外层:枚举所有子串长度，从1开始
        for (int j = 1; j < len; j++) {
            // 内层:从(0,j]判断该区域内回文情况
            for (int i = 0; i < j; i++) {
                // 首尾不相等时，必不是回文串
                if (cs[i] != cs[j]) {
                    dp[i][j] = false;
                } else {
                    // 首尾相等时，有2种情况
                    // 情况1：s[i...j]长度不超过3，不用检查必为回文串
                    // 情况2：s[i...j]长度大于3，由s[i+1...j-1]来判断
                    dp[i][j] = j - i + 1 <= 3 || dp[i + 1][j - 1];
                }
                // 更新max和begin
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "babad";
        System.out.println(solution3.longestPalindrome(s));
    }

}
