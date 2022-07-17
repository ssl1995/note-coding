package 刷题笔记.力扣.剑指Offer.第二版.数据结构.树.q55_I_二叉树的深度.练习;

import 刷题笔记.力扣.utils.TreeNode;

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
