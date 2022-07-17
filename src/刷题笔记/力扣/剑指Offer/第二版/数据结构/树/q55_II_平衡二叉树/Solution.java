package 刷题笔记.力扣.剑指Offer.第二版.数据结构.树.q55_II_平衡二叉树;


import 刷题笔记.力扣.utils.TreeNode;

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
        int rightHeight = process(head.right);
        // 失败case
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 成功case
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
