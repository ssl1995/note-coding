package 程序员代码面试指南.第3章_二叉树问题.前中后序遍历.力扣;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode144 {
    // 二叉树前序遍历
    public List<Integer> preorderTraversal(TreeNode head) {
        if (head == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        // 先序：头右左入栈
        while (!stack.isEmpty()) {
            head = stack.pop();
            res.add(head.val);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        return res;
    }
}
