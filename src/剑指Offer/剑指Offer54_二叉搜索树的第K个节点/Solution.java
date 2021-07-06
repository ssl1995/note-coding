package 剑指Offer.剑指Offer54_二叉搜索树的第K个节点;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 法1:二叉搜索树的中序遍历,用链表存数值,返回第size-k个元素就是第k大的元素
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderByLR(root, list);
        // 第1大的数->排序后第size-1个数
        // 第k大的数->排序后第size-k个数
        return list.get(list.size() - k);
    }


    private void inOrderByLR(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderByLR(root.left, list);
        list.add(root.val);
        inOrderByLR(root.right, list);
    }
}
