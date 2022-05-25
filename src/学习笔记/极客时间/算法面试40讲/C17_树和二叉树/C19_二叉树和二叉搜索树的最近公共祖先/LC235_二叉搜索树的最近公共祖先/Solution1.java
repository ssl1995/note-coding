package 学习笔记.极客时间.算法面试40讲.C17_树和二叉树.C19_二叉树和二叉搜索树的最近公共祖先.LC235_二叉搜索树的最近公共祖先;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/17 8:39 AM
 * @description
 */
public class Solution1 {

    /**
     * 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 改变原树结构：保证p,q最小右大
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        // p是最小值，q是最大值；root作为遍历指针去遍历BST
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
