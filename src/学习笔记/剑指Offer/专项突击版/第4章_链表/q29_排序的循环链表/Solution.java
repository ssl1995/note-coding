package 学习笔记.剑指Offer.专项突击版.第4章_链表.q29_排序的循环链表;

/**
 * @author SongShengLin
 * @date 2021/9/29 9:16 上午
 * @description
 */
public class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {// 没有结点
            head = node;
            node.next = head;
        } else if (head.next == null) {// 只有一个结点
            head.next = node;
            node.next = head;
        } else {// 大于1个结点
            insertNode(head, node);
        }
        return head;
    }

    private void insertNode(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;
        // 遍历找到cur.val<=node.val<=next.val 并且 找到最大值结点(排序链表中最大值结点就是末尾节点，也就是next!=head)
        while ((cur.val > node.val || next.val < node.val) && next != head) {
            cur = next;
            next = next.next;
            // 一定要有=，因为相同节点取最后
            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }
        // 插入node结点:cur.val<=node.val<=next.val存在，就插入中间
        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;
        } else {// 如果不存在，就插入到最大值和头结点之间
            // head不一定是从最小值开始指向，所以不能用下面两行
            // biggest.next = node;
            // node.next = head;

            node.next = biggest.next;
            biggest.next = node;
        }
    }
}
