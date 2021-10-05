package 读书笔记.剑指Offer.第二版.剑指Offer24_反转链表;

import 读书笔记.剑指Offer.utils.ListNode;

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
