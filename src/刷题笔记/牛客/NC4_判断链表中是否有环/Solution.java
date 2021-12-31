package 刷题笔记.牛客.NC4_判断链表中是否有环;

import 读书笔记.剑指Offer.utils.ListNode;

public class Solution {

    // 判断链表是否有环，返回布尔值
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        // 快指针走2步,慢指针走1步
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
