package 剑指Offer.第二版.剑指Offer18_删除链表结点;


import 剑指Offer.utils.ListNode;

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
