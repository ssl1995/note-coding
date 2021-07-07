package 程序员代码面试指南.第3章_二叉树问题.前中后序遍历.力扣;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode145 {
    // 二叉树后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        // 后序：头左右入s1的同时，弹出元素入s2
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
        return res;
    }
}
