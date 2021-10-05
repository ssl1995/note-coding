package 力扣.刷题.LC876_链表中间节点;

import 读书笔记.剑指Offer.utils.ListNode;

public class Solution {
    // 原题:奇数在中间,偶数在中间靠右
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        // 快慢指针从头开始
        ListNode fast = head;
        ListNode slow = head;
        // 奇数在中间,偶数在中间第二个
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 变种:奇数在中间,偶数在中间靠左
    public ListNode middleNode1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 奇数在中间,偶数在中间第一个
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
