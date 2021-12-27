package 剑指Offer.第二版.第6章_面试中的各项能力.q55_I_二叉树的深度;


import 剑指Offer.utils.TreeNode;

public class Solution {

    /**
     * 输入一棵二叉树的根节点，求该树的深度。
     * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度
     */
    public int maxDepth(TreeNode root) {
        // 越过叶子节点，返回深度为0
        if (root == null) {
            return 0;
        }
        // 根节点深度为1，如果只有左子树，深度为左子树+1;如果只有右子树，深度为右子树+1
        // 如果既有左子树、右子树，深度为两者最大值+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
