package 剑指Offer.第二版.第5章_优化时间和空间效率.q52_两个链表的第一个相交结点;

import 剑指Offer.utils.ListNode;

public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int len = 0;
        while (cur1 != null) {
            cur1 = cur1.next;
            len++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            len--;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = len > 0 ? pHead1 : pHead2;
        cur2 = cur1 == pHead1 ? pHead2 : pHead1;
        len = Math.abs(len);
        while (len > 0) {
            cur1 = cur1.next;
            len--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
