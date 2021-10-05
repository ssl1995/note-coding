package 牛客.刷题.NC15_二叉树的层次遍历;

import 读书笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    // 按层打印二叉树，与剑指Offer32-II相同
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>() {
            };
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            // 难点：一层 一层的打印，需要从size--开始遍历队列
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
