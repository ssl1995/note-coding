package 慕课网数据结构.树.练习题.程序员面试指南.是否是搜索二叉树;

import 慕课网数据结构.树.练习题.程序员面试指南.判断是否是平衡二叉树.TreeNode;

import java.util.Stack;

public class LC98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        double leftVal = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= leftVal) {
                    return false;
                }
                leftVal = root.val;
                root = root.right;
            }
        }
        return true;
    }
}
