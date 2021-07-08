package 力扣刷题.LC142_环形链表II;

import 力扣刷题.utils.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        // 快指针走2步,慢指针走1步
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast重新指向头结点
        fast = head;
        // 快指针走1步,慢指针走1步
        while (fast != slow) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
