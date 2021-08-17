package 牛客算法课.基础班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历;

import java.util.Stack;

public class NotRecursiveTraverse {
    // 先序非递归遍历(力扣144)
    public static void preTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            // 先序:先压右孩子,再压左孩子
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println();
    }

    // 中序非递归遍历(力扣94)
    public static void inTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            // 中序非递归遍历先把所有左子树入栈
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                // 左子树到null就出栈，操作+入右子树
                head = stack.pop();
                System.out.println(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    // 后序非递归遍历（力扣145）
    public static void posTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();// 收集栈:存头右左
        Stack<TreeNode> temp = new Stack<>();// 辅助栈:存收集栈每次的出栈
        stack.push(head);
        while (!stack.isEmpty()) {
            // 辅助栈每次收集收集栈的出栈元素
            head = stack.pop();
            temp.push(head);
            // 收集栈每次存左右,出的时候就变成右左了
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        // 辅助栈依次出栈就是后续遍历
        while (!temp.isEmpty()) {
            System.out.println(temp.pop().value + "");
        }
        System.out.println();
    }
}
