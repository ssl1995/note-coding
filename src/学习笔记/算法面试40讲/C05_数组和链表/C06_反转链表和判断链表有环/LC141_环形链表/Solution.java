package 学习笔记.算法面试40讲.C05_数组和链表.C06_反转链表和判断链表有环.LC141_环形链表;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/2/15 11:31 PM
 * @description
 */
public class Solution {
    /**
     * 判断链表是否有环
     */
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
