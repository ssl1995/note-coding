package 读书笔记.剑指Offer.第二版.剑指Offer55_II_平衡二叉树;


import 读书笔记.剑指Offer.utils.TreeNode;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        return process(root) != -1;
    }

    // 左右子树高度差<=1,返回真实高度;左右子树高度差>1,返回-1
    private int process(TreeNode head) {
        if (head == null) {
            return 0;
        }
        // 获取左子树高度信息
        int leftHeight = process(head.left);
        if (leftHeight == -1) {
            return -1;
        }
        // 获取右子树高度信息
        int rightHeight = process(head.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差<=1,返回真实高度;左右子树高度差>1,返回-1
        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
