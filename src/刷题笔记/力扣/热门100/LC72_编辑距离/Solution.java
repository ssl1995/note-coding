package 刷题笔记.力扣.热门100.LC72_编辑距离;

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
        int n1 = word1.length();
        int n2 = word2.length();
        // dp[i][j] = word1到i位置转换成word2到j位置的最少步数
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一列：word2=null,word1每个位置需要删除的步数=最少步数
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = i;
        }
        // 第一行：word1=null,word2每个位置需要增加的步数=最少步数
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 该位置元素相同，不操作，由上一次dp决定
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 该位置元素不同，有三种操作状态，取三者最小+1
                    // “dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
                    // 以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
                    // (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
                    // (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
                    // (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String w1 = "horse";
        String w2 = "ros";
        System.out.println(solution.minDistance(w1, w2));
    }
}
