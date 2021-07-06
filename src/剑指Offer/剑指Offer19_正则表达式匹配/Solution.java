package 剑指Offer.剑指Offer19_正则表达式匹配;

public class Solution {

    // 最直观版
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j]表示s前i-1个字符,p前j-1个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0] :s前0个字符和p的前0个字符默认是空串=匹配
        // 注意：由于多了[0][0],所以dp[i][j],定位到的是s[i-1]和p[j-1]的字符
        dp[0][0] = true;
        // 初始化首行:当s为空串,p的偶数位为*才能匹配
        for (int j = 2; j < n + 1; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        // 状态转移
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 当p[j-1]=*时,有三种情况
                if (p.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) {// p[j-2]出现0次
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) {// p[j-2]出现1次 且 当前i-1和j-2指向的字符相同
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && p.charAt(j - 2) == '.') {// 最特殊情况:p[j-2]=. p[j-1]=*时 根据条件知是万能匹配
                        dp[i][j] = true;
                    }
                } else {// 当p[j-1]!=*时,有两种情况
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) {// 前面元素之前都匹配 且 当前元素也相同
                        dp[i][j] = true;
                    } else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') { //  前面元素之前都匹配 且 p的当期元素是.
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m][n];
    }

    // 用三目运算符优化使代码更美观,更快
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j]表示s前i-1个字符,p前j-1个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0] :s前0个字符和p的前0个字符默认是空串=匹配
        // 注意：由于多了[0][0],所以dp[i][j],定位到的是s[i-1]和p[j-1]的字符
        dp[0][0] = true;
        // 初始化首行:当s为空串,p的偶数位为*才能匹配
        for (int j = 2; j < n + 1; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        // 状态转移
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = p.charAt(j - 1) == '*' ?
                        dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') :
                        dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
            }
        }
        return dp[m][n];
    }
}
