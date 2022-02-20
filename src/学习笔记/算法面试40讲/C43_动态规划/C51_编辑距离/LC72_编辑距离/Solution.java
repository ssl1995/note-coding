package 学习笔记.算法面试40讲.C43_动态规划.C51_编辑距离.LC72_编辑距离;

/**
 * @author SongShengLin
 * @date 2022/1/27 9:11 AM
 * @description
 */
public class Solution {

    /**
     * 编辑距离
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j] = word1到i位置转换成word2到j位置的最少步数
        int[][] dp = new int[m + 1][n + 1];
        // 第一列：word2=null,word1每个位置需要删除的步数=最少步数
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        // 第一行：word1=null,word2每个位置需要增加的步数=最少步数
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 该位置元素相同，最少步数由上一次dp决定
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // “dp[i-1][j-1]表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
                    // word1="horse"，word2="ros"，且 dp[5][3] 为例：
                    // (1) dp[i-1][j-1]=dp[4][2]=替换，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro
                    // (2) dp[i][j-1]=dp[5][2]=插入，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro
                    // (3) dp[i-1][j]=dp[4][3]=删除，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros

                    // 有三种操作状态，取三者最小+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String w1 = "horse";
        String w2 = "ros";
        System.out.println(solution.minDistance(w1, w2));
    }
}
