package 学习笔记.极客时间.算法面试40讲.C17_树和二叉树.C19_二叉树和二叉搜索树的最近公共祖先.LC235_二叉搜索树的最近公共祖先;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/17 8:39 AM
 * @description
 */
public class Solution {

    /**
     * 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 不改变原树结构
        TreeNode cur = root;
        while (true) {
            if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else {
                break;
            }
        }
        return cur;
    }
}
