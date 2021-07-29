package tag刷题.C06_树问题.剑指Offer32_从上到下打印二叉树3;


import 剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 题目：实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，其他行以此类推。

    // 法1：统一牛客NC14，只能使用ArrayList作为数据结构
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // 牛客NC14，限定死只能用ArrayList作为queue数据结构
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            // 在queue中该长度内进行宽度遍历
            for (int i = queue.size(); i > 0; i--) {
                // 在ArrayList中获取第一个元素，并移除
                TreeNode node = queue.get(0);
                queue.remove(0);
                if (res.size() % 2 == 0) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
                }
                // 以下是正常层次遍历存结点
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

    // 法2：LinkedList作为数据结构
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        // LinkedList作为queue数据结构
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // temp双端队列存这一层的打印结点值
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                // 辅助链表存每一层的结点
                TreeNode node = queue.poll();
                // List<List>的长度=层数，≠全部元素个数
                // res.size从0开始=第一层，尾插法
                if (res.size() % 2 == 0) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                // queue存左右孩子节点
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

    public static void main(String[] args) {
        LinkedList<Integer> temp = new LinkedList<>();
        temp.addLast(4);
        temp.addLast(5);
        temp.addLast(6);
        System.out.println(temp);
    }


}
