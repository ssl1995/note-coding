package 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.前中后序遍历二叉树;

import 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.判断完全二叉树的结点个数.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public void InOrderNoRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            // 先将左孩子全部入栈
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                // 此时head==null,并且Stack非空
                // 弹出栈顶元素
                head = stack.pop();
                System.out.println(head.val + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    // 力扣94
    private LinkedList<Integer> list = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 此时head==null,并且Stack非空
                // 弹出栈顶元素
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
