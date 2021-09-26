package 慕课网数据结构.树.练习题.程序员面试指南.前中后序遍历二叉树;


import 慕课网数据结构.树.练习题.程序员面试指南.判断完全二叉树的结点个数.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    // 二叉树得非递归的前序遍历:用一个栈，头结点先入栈，接着是右孩子入栈
    public void preOrderUnRecur(Node head) {
        System.out.println("preOder:");
        if (head != null) {
            // 1.头结点先入栈
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            // 2.循环遍历栈，右孩子先入栈
            while (!stack.isEmpty()) {
                head = stack.pop();
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    // 力扣144:二叉树得前序遍历
    private LinkedList<Integer> list = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }
}
