package 学习笔记.剑指Offer.第二版.第7章_两个面试案例.q68_I_二叉搜索树的最近公共祖先.练习;

import 学习笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/1/18 12:00 AM
 * @description
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode node = p;
            p = q;
            q = node;
        }
        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
