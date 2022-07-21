package 刷题笔记.力扣.热门100.LC104_二叉树最大深度;

import 刷题笔记.力扣.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/7/21 08:38
 * @description
 */
public class Solution {

    /**
     * 求一个二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
