package 刷题笔记.力扣.热门100.LC437_路径之和III;

import 刷题笔记.力扣.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/25 9:11 AM
 * @description
 */
public class Solution {

    private int target;
    private int res;

    /**
     * 路径之和III
     * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * 输出：3
     * 解释：和等于 8 的路径有 3 条，如图所示。
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.target = targetSum;
        res = 0;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // 先序遍历二叉树，每来到一个结点，以当前节点查找为根，查找路径和为target的数量
        process(node, node.val);

        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }

    }

    private void process(TreeNode root, int preSum) {
        if (preSum == target) {
            res++;
            // 不用结束，继续往下
            // return;
        }
        if (root.left != null) {
            process(root.left, preSum + root.left.val);
        }
        if (root.right != null) {
            process(root.right, preSum + root.right.val);
        }
    }


}
