package 力扣.刷题.LC1143_最长公共子序列;

public class Solution {
    // 题目：求最长公共子序列的长度
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.equals("") || text2.equals("")) {
            return 0;
        }
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        // 画出dp表
        int[][] dp = getDpArr(c1, c2);
        return dp[c1.length - 1][c2.length - 1];
    }

    private int[][] getDpArr(char[] c1, char[] c2) {
        // dp[i][j]:c1[0...i]到c2[0...j]的最大公共子序列长度
        int[][] dp = new int[c1.length][c2.length];
        // 根据定义：c1[0]==c2[0]，dp[0][0]=1
        dp[0][0] = c1[0] == c2[0] ? 1 : 0;
        // 先思考动态转移公式：根据需要初始化第一行和第一列
        // 初始化第一行
        for (int i = 1; i < c2.length; i++) {
            // 第一行的dp值只能为1或0，当c1[0]==c2[i]时为1
            // 根据dp[i][j]定义，前面取到过的最大dp，后面没有遇到比它小的，当前dp也还是它
            // 所以用Math.max(dp[0][i - 1],...)
            dp[0][i] = Math.max(dp[0][i - 1], c1[0] == c2[i] ? 1 : 0);
        }
        // 初始化第一列
        for (int i = 1; i < c1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], c1[i] == c2[0] ? 1 : 0);
        }
        // 思考动态转移公式
        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                // 取c1前一位和c2前一位的dp最大值
                int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (c1[i] == c2[j]) {
                    // 两个i，j对应字符相同，当前dp值为Math.max(max, dp[i - 1][j - 1] + 1)
                    dp[i][j] = Math.max(max, dp[i - 1][j - 1] + 1);
                } else {
                    // 两个i，j对应字符不相同，当前dp值为max
                    dp[i][j] = max;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23A456A";
        System.out.println(solution.longestCommonSubsequence(s1, s2));
    }
}
