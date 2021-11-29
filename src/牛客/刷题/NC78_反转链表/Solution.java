package 牛客.刷题.NC78_反转链表;

import 剑指Offer.utils.ListNode;

public class Solution {

    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        // pre = 待反转结点的前一个结点，最后返回它
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
