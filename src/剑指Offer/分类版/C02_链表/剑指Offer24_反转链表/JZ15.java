package 剑指Offer.分类版.C02_链表.剑指Offer24_反转链表;

import 剑指Offer.utils.ListNode;

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
