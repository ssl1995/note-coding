package 刷题笔记.力扣.热门100.LC226_翻转二叉树;

import 刷题笔记.力扣.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/6/18 21:34
 * @description
 */
public class Solution {

    /**
     * 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}
