package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q55_I_二叉树的深度.练习;

import 学习笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/1/16 3:07 PM
 * @description
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
