package 牛客算法课.初级班.课5_链表的环形问题和二叉树;

import 牛客算法课.初级班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.Node;

import java.util.LinkedList;

public class IsCST {
    public static boolean isCST(Node head) {
        if (head == null) {
            return false;
        }
        LinkedList<Node> queue = new LinkedList<>();
        boolean isLeafNode = false;// 标识后续是否是叶子节点
        queue.offer(head);
        Node leftChild;
        Node rightChild;
        while (!queue.isEmpty()) {
            head = queue.poll();
            leftChild = head.left;
            rightChild = head.right;
            if (// 1.当前节点有右孩子无左孩子，返回false
                // 2.满足上面后，如果左右孩子任一非空就不是叶子节点
                    ((leftChild == null && rightChild != null)) || (isLeafNode && (leftChild != null || rightChild != null))
            ) {
                return false;
            }
            if (leftChild != null) {
                queue.offer(leftChild);
            }
            if (rightChild != null) {
                queue.offer(rightChild);
            } else {
                // 3.只要右孩子为空，说明后续节点必须为叶子节点
                isLeafNode = true;
            }
        }
        return true;
    }
}
