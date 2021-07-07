package 程序员代码面试指南.第2章_链表问题.两个单链表相交的问题.力扣;

public class LeetCode141 {
    // 141. 环形链表I:判断是否有环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
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
