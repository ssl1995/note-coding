package 刷题笔记.力扣.热门100.LC96_不同的二叉搜索树;

/**
 * @author SongShengLin
 * @date 2022/2/21 10:05 PM
 * @description
 */
public class Solution {
    /**
     * 不同的二叉搜索树
     * 求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种
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
        // dp[i]:长度为i个的BST个数，由于需要长度为n，所以数组长度为n+1
        int[] dp = new int[n + 1];
        // 空树或1个节点，均只有一个BST
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int root = 1; root <= i; root++) {
                // 右子树:root-1
                // 左子树:i-root
                // 笛卡尔积：左子树长度乘右子树长度
                int count = dp[root - 1] * dp[i - root];
                dp[i] += count;
            }
        }

        return dp[n];
    }

}
