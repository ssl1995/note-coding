package 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.前中后序遍历二叉树;


import 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.判断完全二叉树的结点个数.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PosOrder {
    // 后续遍历1：使用两个栈
    public void posOrderNoRecur(Node head) {
        System.out.println("posOrder: ");
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        // 1.利用非递归的前序遍历方法实现：中右左的出栈顺序
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        // 2.s2出栈
        while (!s2.isEmpty()) {
            // 3.实现业务逻辑
            System.out.println(s2.pop().val + " ");
        }
        System.out.println();
    }

    // 力扣145
    private LinkedList<Integer> list = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        // 1.利用非递归的前序遍历方法实现：中右左的出栈顺序
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
        // 2.s2出栈
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }

        return list;
    }

}
