package tag刷题.C05_树问题.剑指Offer55_II_平衡二叉树;

import tag刷题.utils.TreeNode;

public class JZ39 {
    public boolean IsBalanced_Solution(TreeNode root) {
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
        // 左右子树高度差<=1,返回子树最大高度+1;左右子树高度差>1,返回-1
        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
