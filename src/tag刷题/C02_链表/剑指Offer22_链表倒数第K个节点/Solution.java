package tag刷题.C02_链表.剑指Offer22_链表倒数第K个节点;


import tag刷题.utils.ListNode;

public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // 快指针先走k步(K>=1)
        while (k > 0) {
            // 快指针每次都要判断是否为null,注意边界问题
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        // 当快指针走到末尾节点的下一个节点=null时,slow走到倒数第K个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
