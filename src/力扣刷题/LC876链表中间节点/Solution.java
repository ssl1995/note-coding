package 力扣刷题.LC876链表中间节点;

import 力扣刷题.utils.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        // 快慢指针从头开始
        ListNode fast = head;
        ListNode slow = head;
        // 快指针可以前进的条件:非空 且 next也非空,遍历结束
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 奇数:slow指向中间
            // 偶数:slow指向中间第二个
            slow = slow.next;
        }
        return slow;
    }
}
