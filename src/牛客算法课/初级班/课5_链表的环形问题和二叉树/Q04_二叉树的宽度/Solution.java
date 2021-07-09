package 牛客算法课.初级班.课5_链表的环形问题和二叉树.Q04_二叉树的宽度;

import 牛客算法课.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // 二叉树的宽度遍历 = 层次遍历(力扣102)
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 辅助数组在每次循环内生成,保证每一层都是新的List
            List<Integer> temp = new ArrayList<>();
            // 从利用queue的个数来遍历,让每一层的queue都遍历完
            // for写法
            for (int i = queue.size(); i > 0; i--) {
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

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 辅助数组在每次循环内生成,保证每一层都是新的List
            List<Integer> temp = new ArrayList<>();
            // 从利用queue的个数来遍历,让每一层的queue都遍历完
            int len = queue.size();
            // while写法
            while (len > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                len--;
            }
            res.add(temp);
        }
        return res;
    }
}
