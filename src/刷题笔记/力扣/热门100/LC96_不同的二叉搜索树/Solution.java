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
        // BST的中序遍历是严格递增，而条件给的结点范围为[1,n]也是严格递增的
        // 说明每一个结点都可以作为BST的根
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // i作为根时，j作为左右子树分界点
                // 左子树范围:[1,j-1],长度为j-1
                // 右子树范围:[j+1,i],长度为i-j
                // 笛卡尔积：左子树长度乘右子树长度
                int count = dp[j - 1] * dp[i - j];
                dp[i] += count;
            }
        }

        return dp[n];
    }

}
