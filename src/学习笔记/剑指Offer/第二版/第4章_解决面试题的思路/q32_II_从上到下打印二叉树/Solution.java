package 学习笔记.剑指Offer.第二版.第4章_解决面试题的思路.q32_II_从上到下打印二叉树;

import 学习笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * 分行，从上到下打印一个二叉树
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // temp存每一行的数据
            List<Integer> temp = new ArrayList<>();
            // 分行打印，从队列长度往下-1遍历
            // 因为queue的长度每次循环内部都在改变,所以不能以size为遍历结束条件
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                temp.add(node.val);
            }
            res.add(temp);
        }
        return res;
    }
}
