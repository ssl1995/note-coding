package 剑指Offer.正序版.剑指Offer28_对称二叉树;


import 剑指Offer.utils.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        // base1:如果两者同时越过叶子结点，对称成功，返回true
        if (left == null && right == null) {
            return true;
        }
        // base2:左右结点一个到达null,另一个不到达,或者左右结点值不相同，对称失败，返回false
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 对称递归：左右&&右左
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
