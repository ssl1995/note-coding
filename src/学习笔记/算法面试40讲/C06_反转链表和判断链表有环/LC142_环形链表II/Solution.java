package 学习笔记.算法面试40讲.C06_反转链表和判断链表有环.LC142_环形链表II;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/2/15 11:45 PM
 * @description
 */
public class Solution {
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        // 快指针走2步,慢指针走1步
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 以上代码=判断链表是否有环，快指针一旦遇到慢指针，说明肯定有环，让快指针重新指向头结点
        fast = head;
        // 快指针走1步,慢指针走1步
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // 快慢指针一定会在第一个入环结点相遇,证明找wolai笔记
        return fast;
    }
}
