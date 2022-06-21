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

        // 最朴素的做法就是以每个结点都为根节点来统计
        dfs1(root);
        return res;
    }

    private void dfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        // 当前node为根，统计sum和的数量
        dfs2(node, node.val);

        dfs1(node.left);
        dfs1(node.right);

    }

    private void dfs2(TreeNode root, int preSum) {
        if (root == null) {
            return;
        }
        if (preSum == target) {
            res++;
            // 不能return,因为可能孩子节点是负数,preSum减少会再次形成有效路径
            // return;
        }
        if (root.left != null) {
            dfs2(root.left, preSum + root.left.val);
        }
        if (root.right != null) {
            dfs2(root.right, preSum + root.right.val);
        }
    }


}
