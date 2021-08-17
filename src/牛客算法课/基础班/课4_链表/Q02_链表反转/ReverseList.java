package 牛客算法课.基础班.课4_链表.Q02_链表反转;

public class ReverseList {
    // 反转单链表
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 反转双链表
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;// 加一句前指针指向后继
            pre = head;
            head = next;
        }
        return pre;
    }
}
