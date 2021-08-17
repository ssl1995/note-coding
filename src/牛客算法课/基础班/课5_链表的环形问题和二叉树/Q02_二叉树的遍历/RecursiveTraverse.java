package 牛客算法课.基础班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历;

public class RecursiveTraverse {
    // 通用递归序：学习来到当前节点的次数
    public static void commonRecursiveTraverse(TreeNode head) {
        // 递归结束条件
        if (head == null) {
            return;
        }
        // 第一次来到head=先序
        commonRecursiveTraverse(head.left);
        // 第二次来到head=中序
        commonRecursiveTraverse(head.right);
        // 第三次来到head=后序
    }

    // 先序递归遍历
    public static void preRecursiveTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preRecursiveTraverse(head.left);
        preRecursiveTraverse(head.right);
    }

    // 中序递归遍历
    public static void inRecursiveTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        inRecursiveTraverse(head.left);
        System.out.println(head.value);
        inRecursiveTraverse(head.right);
    }

    // 后序递归遍历
    public static void posRecursiveTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        posRecursiveTraverse(head.left);
        posRecursiveTraverse(head.right);
        System.out.println(head.value);
    }
}
