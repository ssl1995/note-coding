package 程序员代码面试指南.第2章_链表问题.反转单双向链表;


public class ReverseList {
    // 反转单链表
    public Node reverserList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 利用head遍历，节省一个空间
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 反转双链表
    public DoubleNode reverserList(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            // 双向链表多加这一行
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
