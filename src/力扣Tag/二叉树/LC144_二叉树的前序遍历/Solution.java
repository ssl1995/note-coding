package 力扣Tag.二叉树.LC144_二叉树的前序遍历;

import 力扣Tag.utils.TreeNode;
import 牛客算法课.初级班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
