package 刷题笔记.力扣.热门100.LC96_不同的二叉搜索树;

/**
 * @author SongShengLin
 * @date 2022/2/21 10:05 PM
 * @description
 */
public class Solution {
    /**
     * 不同的二叉搜索树
     * 输入：n = 3
     * 输出：5
     */
    public int numTrees(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        // dp[i]:长度为i个的BST个数
        int[] dp = new int[n + 1];
        // 空树或1个节点，均只有一个BST
        dp[0] = 1;
        dp[1] = 1;

        // 外层：长度
        for (int i = 2; i <= n; i++) {
            // 内层：根节点可选择的数量
            for (int j = 1; j <= i; j++) {
                // J为根的BST个数
                int rootJ = dp[j - 1] * dp[i - j];
                dp[i] += rootJ;
            }
        }

        return dp[n];
    }

}
