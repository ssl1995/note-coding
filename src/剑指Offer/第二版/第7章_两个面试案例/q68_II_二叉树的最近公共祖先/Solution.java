package 剑指Offer.第二版.第7章_两个面试案例.q68_II_二叉树的最近公共祖先;


import 剑指Offer.utils.TreeNode;

public class Solution {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case:root越过叶子节点,返回null 或者root = p/q,返回root
        if (root == null || root == p || root == q) {
            return root;
        }
        // 普通二叉树找最近公共祖先，使用后序遍历，用left和right接收
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 根据base case:当left和right同时不为空,说明p,q在root异侧,root就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 当left和right同时为空:说明root左右子树不包含p,q,无公共祖先
        // 当left和right一个空,一个不空，最近公共祖先肯定在root非空的那个子树里
        return left != null ? left : right;
    }
}
