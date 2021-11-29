package 剑指Offer.第二版.剑指Offer18_删除链表结点;

import 剑指Offer.utils.ListNode;

public class JZ56 {
    // 升序链表删除重复结点，重复结点不保留
    // 1-2-2，返回1
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = pHead;
        while (cur != null) {
            // 没有后继||前后不一致，就加入pre后继
            if (cur.next == null || cur.val != cur.next.val) {
                pre.next = cur;
                pre = cur;
            }
            // 否则，就一直后移cur，让cur指向相同节点的最后一个节点
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
    }
}
