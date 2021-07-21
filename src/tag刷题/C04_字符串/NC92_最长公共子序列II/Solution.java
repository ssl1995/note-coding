package tag刷题.C04_字符串.NC92_最长公共子序列II;

public class Solution {
    // 求两个字符串的最长公共子序列，目前给出的数据，仅仅会存在一个最长的公共子序列
    public String LCS(String s1, String s2) {
        // 条件规定：失败都返回-1
        if (s1 == null || s2 == null || s1.equals("") || s2.equals("")) {
            return "-1";
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        // 画出dp表
        int[][] dp = getDpArr(c1, c2);
        // 根据dp表倒推最长公共子序列
        int m = c1.length - 1;
        int n = c2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;// 从后往前遍历
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {// 左边移动
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {// 上方移动
                m--;
            } else {// 左上角移动
                // dp[m][n]!=dp[m][n-1]或者!=dp[m-1][n],肯定是选择dp[m-1][n-1]+1 且s1[i]==s2[j]
                // res[index--] = c2[n];// 所以这种写法也行
                res[index--] = c1[m];
                m--;
                n--;
            }
        }
        // 条件规定：如果最长公共子串为“”,返回-1
        return String.valueOf(res).equals("") ? "-1" : String.valueOf(res);
    }

    private int[][] getDpArr(char[] c1, char[] c2) {
        // dp[i][j]:c1[0...i]到c2[0...i]的最大公共子序列长度
        int[][] dp = new int[c1.length][c2.length];
        // 根据定义：c1[0]==c2[0]，dp[0][0]=1
        dp[0][0] = c1[0] == c2[0] ? 1 : 0;
        // 先初始化第一行和第一列
        for (int i = 1; i < c2.length; i++) {
            // 子序列是只要前面取到最大过，后面都是它，所以用Math.max
            dp[0][i] = Math.max(dp[0][i - 1], c1[0] == c2[i] ? 1 : 0);
        }
        for (int i = 1; i < c1.length; i++) {
            // 子序列是只要前面取到最大过，后面都是它，所以用Math.max
            dp[i][0] = Math.max(dp[i - 1][0], c1[i] == c2[0] ? 1 : 0);
        }
        // 根据递推公式算其他
        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                // 取c1前一位和c2前一位的dp最大值
                int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (c1[i] == c2[j]) {// 两个i，j对应字符相同
                    dp[i][j] = Math.max(max, dp[i - 1][j - 1] + 1);
                } else {// 两个i，j对应字符不相同：取max
                    dp[i][j] = max;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String s1 = "111";
        String s2 = "222";
        Solution solution = new Solution();
        System.out.println(solution.LCS(s1, s2));
    }
}
