package 读书笔记.牛客算法课.基础班提升.课3_最长回文子串和滑动窗口.Q01_最长回文子串问题.NC17_最长回文串长度;


public class Solution3 {
    // 动态规划法：求最长回文子串的长度
    public int getLongestPalindrome(String A, int n) {
        if (n < 2) {
            return 1;
        }
        int maxLen = 1;
        char[] cs = A.toCharArray();
        // dp[i][j]:表示s[i][j]是否是回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 经验：dp区域是正方形的话，通常左下角区域无效不需要再填，因为走过的区域不用再走
        for (int j = 1; j <= n - 1; j++) { // 上三角区域，按列从上到下填
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
                }
            }
        }
//        for (int i = n - 2; i >= 0; i--) {// 从右下往上填也行
//            for (int j = n - 1; j > i; j--) {
//            }
//        }
        return maxLen;
    }
}
