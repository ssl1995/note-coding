package 学习笔记.剑指Offer.专项突击版.第4章_链表.q22_链表中环的入口结点;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author songshenglin
 * @date 2021/9/21 11:14
 * @description 链表有环，原书的解法
 */
public class Solution {
    /**
     * 判断链表是否有环，有环就返回入环结点，无环就返回null
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        ListNode fast = head;
        while (fast != inLoop) {
            fast = fast.next;
            inLoop = inLoop.next;
        }
        return fast;
    }

    /**
     * 获得入环结点的任意一个结点
     *
     * @param head
     * @return
     */
    private ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

}
