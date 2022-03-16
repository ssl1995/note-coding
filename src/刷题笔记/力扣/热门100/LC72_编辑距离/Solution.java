package 刷题笔记.力扣.热门100.LC72_编辑距离;

/**
 * @author SongShengLin
 * @date 2022/1/27 9:11 AM
 * @description
 */
public class Solution {

    /**
     * 编辑距离
     * 返回将word1转换成word2所使用的最少操作数
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j] = word1到i位置转换成word2到j位置的最少步数
        // 经验：字符串的动态规划，字符串可能为null，所以m+1、n+1
        int[][] dp = new int[m + 1][n + 1];
        // 初始化第一列：word2=null,最小步数为word1的遍历的长度
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        // 初始化第一行：word1=null,最小步数为word2的遍历的长度
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        // 动态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前位置元素相同，不需要计算，和上一个dp值决定
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当前位置元素不相同，有三种状态：替换、删除、插入；取三种状态最小值+1
                    // dp[i-1][j-1]表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作
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
        String w1 = "intention";
        String w2 = "execution";
        System.out.println(solution.minDistance(w1, w2));
    }
}
