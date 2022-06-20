package 刷题笔记.力扣.热门100.LC236_二叉树最近公共祖先;

import 刷题笔记.力扣.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/6/19 10:43
 * @description
 */
public class Solution {

    /**
     * 二叉树最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case: 空节点
        if (root == null) {
            return null;
        }
        // base case:遇到p、q节点
        if (root == p || root == q) {
            return root;
        }
        // 后序遍历，获取左右子树判断
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右子树都不为空，说明p、q都在异侧，root就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 左右孩子没遍历到，就返回右左孩子
        // 两者都是空，就返回空
        return left == null ? right : left;
    }
}
