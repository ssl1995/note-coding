package 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.是否是搜索二叉树;


import java.util.Stack;

public class IsBST {
    public boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        // double防止边界问题
        double leftVal = -Double.MAX_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (leftVal >= head.value) {
                    return false;
                }
                leftVal = head.value;
                head = head.right;
            }
        }
        return true;
    }
}
