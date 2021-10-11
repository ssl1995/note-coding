package 读书笔记.剑指Offer.第三版.第8章_树.q51_节点值之和最大路径;

/**
 * @author SongShengLin
 * @date 2021/10/11 8:38 上午
 * @description
 */
public class Solution {
    // 这个方法跑力扣124会超时
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int[] maxLeft = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.left, maxLeft));

        int[] maxRight = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.right, maxRight));

        max[0] = Math.max(maxLeft[0], maxRight[0]);
        max[0] = Math.max(max[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
