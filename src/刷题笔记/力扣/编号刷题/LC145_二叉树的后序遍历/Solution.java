package 刷题笔记.力扣.编号刷题.LC145_二叉树的后序遍历;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 后续每次出栈,将结果进辅助栈,实现头右左倒序
            temp.push(node);
            // 要实现出栈是头右左,收集栈就要左右入栈
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        // 辅助栈出栈,头右左变成左右头
        while (!temp.isEmpty()) {
            res.add(temp.pop().val);
        }
        return res;
    }
}
