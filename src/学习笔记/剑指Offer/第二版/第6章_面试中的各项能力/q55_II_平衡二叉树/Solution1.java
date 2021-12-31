package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q55_II_平衡二叉树;

import 学习笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2021/12/27 9:17 AM
 * @description
 */
public class Solution1 {
    /**
     * 树形递归，需要判断返回值类需要什么信息
     * 平衡二叉树：需要平衡和高度两种信息
     */
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
        // 单个节点，是平衡，深度为0
        if (head == null) {
            return new ReturnType(true, 0);
        }
        // 后序遍历，获取左右子树的情况
        ReturnType leftType = process(head.left);
        ReturnType rightType = process(head.right);
        // 整体平衡:左子树平衡、右子树平衡、高度差<=1
        boolean isBalanced = leftType.isBalanced && rightType.isBalanced && Math.abs(leftType.height - rightType.height) <= 1;
        // 整体高度:左右子树最大高度+1
        int height = Math.max(leftType.height, rightType.height) + 1;
        return new ReturnType(isBalanced, height);
    }

}
