package 刷题笔记.力扣.热门100.LC101_对称二叉树;

import 刷题笔记.力扣.utils.TreeNode;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/14 3:24 PM
 * @Describe:
 */
public class Solution {

    /**
     * 验证二叉树是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        return process(root.left, root.right);
    }

    private boolean process(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && process(p.left, q.right) && process(p.right, q.left);
    }
}
