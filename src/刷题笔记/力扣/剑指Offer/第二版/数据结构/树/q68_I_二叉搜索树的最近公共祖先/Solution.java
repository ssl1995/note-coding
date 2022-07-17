package 刷题笔记.力扣.剑指Offer.第二版.数据结构.树.q68_I_二叉搜索树的最近公共祖先;

import 刷题笔记.力扣.utils.TreeNode;

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
