package 力扣.剑指Offer.第二版.剑指Offer32_二叉树层次遍历;

import 力扣.剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 题目：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。（=二叉树层序遍历）
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
            // 层次遍历，需要从确定每层的长度
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
