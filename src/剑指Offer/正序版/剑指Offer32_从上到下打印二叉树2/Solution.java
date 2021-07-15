package 剑指Offer.正序版.剑指Offer32_从上到下打印二叉树2;


import 剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 难点: i = queue.size(); i > 0
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            // temp存每一行的数据
            List<Integer> temp = new ArrayList<>();
            // 如下是错误的:for (int i = 0; i < queue.size(); i++)
            for (int i = queue.size(); i > 0; i--) {
                // 因为queue的长度每次循环内部都在改变,所以不能以size为遍历结束条件
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
