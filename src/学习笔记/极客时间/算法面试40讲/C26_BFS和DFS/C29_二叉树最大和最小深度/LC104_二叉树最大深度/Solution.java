package 学习笔记.极客时间.算法面试40讲.C26_BFS和DFS.C29_二叉树最大和最小深度.LC104_二叉树最大深度;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/18 8:17 AM
 * @description
 */
public class Solution {
    /**
     * 二叉树最大深度
     * 给定二叉树 [3,9,20,null,null,15,7]
     * 返回最大深度3
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
