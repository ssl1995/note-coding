package tag刷题.C02_链表.剑指Offer18_删除链表结点;

import tag刷题.utils.ListNode;

public class JZ56 {
    // 升序链表删除重复结点
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
            // 本题不保留重复结点，这里不用pre.next = cur
            // 相同节点的最后一个结点不保留，后移cur
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
    }
}
