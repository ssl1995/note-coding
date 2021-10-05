package 读书笔记.剑指Offer.第三版.第4章_链表.q22_链表中环的入口结点;

import 读书笔记.剑指Offer.utils.ListNode;

/**
 * @author songshenglin
 * @date 2021/9/21 11:14
 * @description 链表有环，K神书的解法，用这个更容易记
 */
public class Solution1 {
    /**
     * 判断链表是否有环，有环就返回入环结点，无环就返回null
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
