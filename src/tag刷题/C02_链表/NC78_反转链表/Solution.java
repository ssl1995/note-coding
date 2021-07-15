package tag刷题.C02_链表.NC78_反转链表;

import tag刷题.utils.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = ReverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}
