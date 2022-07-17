package 刷题笔记.力扣.剑指Offer.第二版.数据结构.树.q32_III_从上到下打印二叉树;


import 刷题笔记.力扣.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /**
     * 之字型打印二叉树
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            // temp存每一行的数据
            List<Integer> temp = new ArrayList<>();
            // 打印奇数层：从左到右
            for (int i = deque.size(); i > 0; i--) {
                // 从头部存的奇数层，就从头部取
                TreeNode node = deque.removeFirst();
                temp.add(node.val);
                // 下一层是偶数层，放尾部
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(temp);
            // 此时如果双端队列为空，说明node没有左右孩子，遍历结束
            if (deque.isEmpty()) {
                break;
            }
            // 清空暂存数组
            temp = new ArrayList<>();
            // 保存偶数层:从右到左
            for (int i = deque.size(); i > 0; i--) {
                // 从尾部存的偶数层，就从尾部取
                TreeNode node = deque.removeLast();
                temp.add(node.val);
                // 下一层是奇数层，放头部
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
