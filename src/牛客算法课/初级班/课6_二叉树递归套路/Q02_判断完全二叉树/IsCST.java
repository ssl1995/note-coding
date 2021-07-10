package 牛客算法课.初级班.课6_二叉树递归套路.Q02_判断完全二叉树;

import 牛客算法课.初级班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.Node;

import java.util.LinkedList;

public class IsCST {
    public static boolean isCST(Node head) {
        if (head == null) {
            return false;
        }
        // 宽度优先遍历,使用队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(head);
        // 标识后续是否是叶子节点
        boolean isLeafNode = false;
        Node leftChild;
        Node rightChild;
        while (!queue.isEmpty()) {
            head = queue.poll();
            leftChild = head.left;
            rightChild = head.right;
            if (// 1.当前节点有右孩子无左孩子，返回false
                    (leftChild == null && rightChild != null) ||
                            // 2.如果遇到第一个有左无右的结点,那么接下来的结点必为叶子节点(左右孩子任一非空就不是叶子节点)
                            (isLeafNode && (leftChild != null || rightChild != null))
            ) {
                return false;
            }
            if (leftChild != null) {
                queue.offer(leftChild);
            }
            if (rightChild != null) {
                queue.offer(rightChild);
            } else {
                // 只要右孩子为空，说明遇到第一个有左无右的结点,那么接下来的结点必为叶子节点
                isLeafNode = true;
            }
        }
        return true;
    }
}
