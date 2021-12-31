package 刷题笔记.力扣.LC144_二叉树的前序遍历;

import 读书笔记.剑指Offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            // 先序:先压右孩子,再压左孩子
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }
}
