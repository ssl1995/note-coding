package 剑指Offer.正序版.剑指Offer68_二叉树的最近公共祖先;


import 剑指Offer.utils.TreeNode;

public class Solution {

    // 普通二叉树最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束条件
        // root越过叶子节点,返回null
        // root = p/q,最近公共祖先就是root本身，返回root
        if (root == null || root == p || root == q) {
            return root;
        }
        // 设当前节点为cur,使用后序遍历记录当前节点的左右子树情况,用left和right接收
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 当left和right同时不为空:说明p,q在root异侧,root就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 当left和right同时为空:说明root左右子树不包含p,q,无公共祖先
        // 当left和right一个空,一个不空，最近公共祖先肯定在root非空的那个子树里
        return left != null ? left : right;
    }
}
