package 读书笔记.剑指Offer.第二版.第6章_面试中的各项能力.q55_II_平衡二叉树;


import 读书笔记.剑指Offer.utils.TreeNode;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        return process(root) != -1;
    }

    /**
     * 平衡二叉树：左右子树高度差必<=1
     */
    private int process(TreeNode head) {
        if (head == null) {
            return 0;
        }
        // 后序遍历获取左右子树高度信息
        int leftHeight = process(head.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = process(head.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差<=1,返回真实高度;左右子树高度差>1,返回-1
        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
