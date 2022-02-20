package 学习笔记.算法面试40讲.C05_数组和链表.C06_反转链表和判断链表有环.LC206_反转链表;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/2/15 11:02 PM
 * @description
 */
public class Solution1 {
    /**
     * LC206：反转单链表
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
