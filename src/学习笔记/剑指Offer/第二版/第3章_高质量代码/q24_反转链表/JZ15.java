package 学习笔记.剑指Offer.第二版.第3章_高质量代码.q24_反转链表;

import 学习笔记.剑指Offer.utils.ListNode;

public class JZ15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}
