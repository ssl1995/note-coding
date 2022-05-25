package 学习笔记.极客时间.算法面试40讲.C17_树和二叉树.C19_二叉树和二叉搜索树的最近公共祖先.LC236_二叉树的最近公共祖先;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/17 8:39 AM
 * @description
 */
public class Solution {
    /**
     * 二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 成功的base case:最近公共祖先，两者都不为空
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
