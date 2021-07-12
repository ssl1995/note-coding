package 牛客算法课.基础班.课5_链表的环形问题和二叉树;

import 牛客算法课.基础班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.Node;

import java.util.LinkedList;
import java.util.Queue;

public class WidthTraverse {
    // 二叉树宽度遍历=层次遍历
    public static void widthTraverse(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
        System.out.println();
    }
}
