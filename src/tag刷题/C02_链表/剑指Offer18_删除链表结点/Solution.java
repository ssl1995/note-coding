package tag刷题.C02_链表.剑指Offer18_删除链表结点;


import tag刷题.utils.ListNode;

public class Solution {
    // 删除链表中指定结点值
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {// 如果待删除结点是头结点
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }
}
