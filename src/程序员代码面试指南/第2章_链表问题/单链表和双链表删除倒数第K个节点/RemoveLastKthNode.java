package 程序员代码面试指南.第2章_链表问题.单链表和双链表删除倒数第K个节点;

public class RemoveLastKthNode {
    // 删除单链表的倒数第K个节点
    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null) {
            return null;
        }
        // 1.遍历单链表，k值-1
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        // 2.k=0，说明头结点就是待删除结点
        if (lastKth == 0) {
            return head.next;
        }
        // 3.k<0，说明存在待删除结点
        if (lastKth < 0) {
            // 4.从头开始遍历，k+1直到k=0
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            // 5.k=0，就是删除结点的前一个结点
            cur.next = cur.next.next;
        }
        return head;
    }

    // 删除双链表的倒数第K个节点
    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null) {
            return null;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            return head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            // 删除双向链表
            DoubleNode nextDode = cur.next.next;
            cur.next = nextDode;
            if (nextDode != null) {
                nextDode.last = cur;
            }
        }
        return head;
    }
}
