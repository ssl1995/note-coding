package 剑指Offer.分类版.C06_树问题.剑指Offer32_从上到下打印二叉树3;



import 剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 法1:延续打印二叉树1,2的套路,利用res长度判断奇偶
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                // 辅助链表存每一层的结点
                TreeNode node = queue.poll();
                // 利用res的元素个数判断奇偶层
                if (res.size() % 2 == 0) { // 奇数层,正常从尾部进队列
                    temp.addLast(node.val);
                } else {// 偶数层,从头部进队列
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

    // 法2:奇偶分层加入双端队列
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> dequeue = new LinkedList<>();
        dequeue.add(root);
        while (!dequeue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            // 打印偶数层节点：头进尾出,保证从左到右出
            for (int i = dequeue.size(); i > 0; i--) {
                TreeNode node = dequeue.removeFirst();
                temp.add(node.val);
                if (node.left != null) {
                    dequeue.addLast(node.left);
                }
                if (node.right != null) {
                    dequeue.addLast(node.right);
                }
            }
            res.add(temp);
            // 若无偶数层节点，就跳出
            if (dequeue.isEmpty()) {
                break;
            }
            // 打印偶数层节点：尾进头出,保证从右往左出
            temp = new ArrayList<>();// temp每次更换需要重新指向新的链表
            for (int i = dequeue.size(); i > 0; i--) {
                TreeNode node = dequeue.removeLast();
                temp.add(node.val);
                // 偶数层从右往左入节点
                if (node.right != null) {
                    dequeue.addFirst(node.right);
                }
                if (node.left != null) {
                    dequeue.addFirst(node.left);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
