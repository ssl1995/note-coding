package 剑指Offer.分类版.C05_树问题.剑指Offer32_之字打印二叉树;


import 剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 题目：实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，其他行以此类推。

    // LinkedList作为数据结构
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
                // res.size()==0,第一层，从左到右打印
                // res.size()==1,第二层，从右到左打印
                // res.size()==2,第三层，从左到右打印
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
