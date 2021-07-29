package tag刷题.C05_树问题.剑指Offer28_对称二叉树;


import tag刷题.utils.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        // 递归成功:左右结点同时到达null
        if (left == null && right == null) {
            return true;
        }
        // 递归失败:左右结点一个到达null,另一个不到达,或者左右结点值不相同
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 递归:(左左,右右) && (左右,右左)
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
