package 剑指Offer.分类版.C06_二叉树.剑指Offer32_从上到下打印二叉树1;



import 剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        // 方法:从上到下打印二叉树,利用队列的先进先出的特性
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 由于res数组长度未知,先用链表结构存打印结果
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            // 先序遍历,每次遍历到当前元素,就出队
            temp.add(pop.val);
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }
        }
        // 生成链表长度的res数组,重新赋值即可
        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}
