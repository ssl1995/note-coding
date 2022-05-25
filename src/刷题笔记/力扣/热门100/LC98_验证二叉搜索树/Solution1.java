package 刷题笔记.力扣.热门100.LC98_验证二叉搜索树;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;


public class Solution1 {

    // Q:利用Morris方法判断是否是搜索二叉树
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        // 力扣边界:这里使用int会越界,所以使用Long的最小值
        long preValue = Long.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            // 如果第二次来到的结点值不产生升序,就不是二叉搜索树
            if (cur.val <= preValue) {
                return false;
            }
            // 否则,更新pre
            preValue = cur.val;

            cur = cur.right;
        }
        return true;
    }
}
