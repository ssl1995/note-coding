package tag刷题.C02_链表.LC141_环形链表I;

import tag刷题.utils.ListNode;

public class Solution {
    // 判断链表是否有环，返回值是布尔值
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        // 初始化：快指针在next.next,慢指针在next上
        ListNode fast = head.next.next;
        ListNode slow = head.next;
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
