package 剑指Offer.C05_树问题.剑指Offer55_II_平衡二叉树;

import 剑指Offer.utils.TreeNode;

public class JZ39 {
    class ReturnType {
        boolean isBalanced;
        int height;

        ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    // 换成树形递归套路，解平衡二叉树问题
    public boolean IsBalanced_Solution(TreeNode root) {
        return process(root).isBalanced;
    }

    private ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        // 获取左右子树的情况
        ReturnType leftType = process(head.left);
        ReturnType rightType = process(head.right);
        // 整体平衡:左子树平衡、右子树平衡、高度差<=1
        boolean isBalanced = leftType.isBalanced && rightType.isBalanced && Math.abs(leftType.height - rightType.height) <= 1;
        // 整体高度:左右子树最大高度+1
        int height = Math.max(leftType.height, rightType.height) + 1;
        return new ReturnType(isBalanced, height);
    }

}
