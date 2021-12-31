package 读书笔记.剑指Offer.专项突击版.第8章_树.q51_节点值之和最大路径;

/**
 * @author SongShengLin
 * @date 2021/10/11 8:38 上午
 * @description
 */
public class Solution1 {

    private int maxSum = Integer.MIN_VALUE;

    // 这个方法跑力扣124不会超时
    public int maxPathSum(TreeNode root) {
        dfs(root);

        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int max = root.val + left + right;

        maxSum = Math.max(maxSum, max);

        return root.val + Math.max(left, right);
    }
}
