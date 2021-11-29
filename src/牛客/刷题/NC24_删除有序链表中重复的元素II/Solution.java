package 牛客.刷题.NC24_删除有序链表中重复的元素II;

import 剑指Offer.utils.ListNode;

public class Solution {
    // 删除重复结点，不保留重复结点：1->2->2,返回1
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;
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
            // 删除所有重复结点：1->2->2,重复结点不保留，返回1
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
    }
}
