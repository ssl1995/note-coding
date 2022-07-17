package 刷题笔记.力扣.剑指Offer.第二版.数据结构.树.q28_对称二叉树;

import 刷题笔记.力扣.utils.TreeNode;

public class JZ58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return recur(pRoot.left, pRoot.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
