package 学习笔记.算法面试40讲.C29_二叉树最大和最小深度.LC111_二叉树最小深度;

import 学习笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/18 8:20 AM
 * @description
 */
public class Solution {
    /**
     * 二叉树最小深度
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 左右子树有一个为0
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        // 左右子树都不为0
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));
    }
}
