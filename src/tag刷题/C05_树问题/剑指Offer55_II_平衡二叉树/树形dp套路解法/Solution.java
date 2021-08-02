package tag刷题.C05_树问题.剑指Offer55_II_平衡二叉树.树形dp套路解法;


import tag刷题.utils.TreeNode;

public class Solution {
    // 树形dp套路:考虑左右子树情况,定义一个情况类接收
    class ReturnType {
        boolean isBalanced;
        int height;

        ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
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
        boolean isBalanced = leftType.isBalanced && rightType.isBalanced
                && Math.abs(leftType.height - rightType.height) <= 1;
        // 整体高度:左右子树最大高度+1
        int height = Math.max(leftType.height, rightType.height) + 1;
        return new ReturnType(isBalanced, height);
    }

}

