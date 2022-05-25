package 刷题笔记.力扣.热门100.LC543_二叉树的直径;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/27 12:01 AM
 * @description
 */
public class Solution {

    private int max;

    /**
     * 二叉树的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        // 二叉树直径：任意两个节点边的最大值=max（左子树深度+右子树深度）
        max = Math.max(max, left + right);
        // 返回当前节点的深度
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(solution.diameterOfBinaryTree(node1));

    }
}
