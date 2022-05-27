package 刷题笔记.力扣.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q54_二叉搜索树的第K个节点;


import 刷题笔记.力扣.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    /**
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     */
    public int kthLargest(TreeNode root, int k) {
        if (k < 0) {
            return -1;
        }
        // 二叉搜索树的中序遍历,用链表存数值,返回第size-k个元素就是第k大的元素
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        // 第1大的数->排序后第size-1个数
        // 第k大的数->排序后第size-k个数
        return list.get(list.size() - k);
    }

    /**
     * 二叉搜索树，用中序遍历，保存二叉树元素进list
     */
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
