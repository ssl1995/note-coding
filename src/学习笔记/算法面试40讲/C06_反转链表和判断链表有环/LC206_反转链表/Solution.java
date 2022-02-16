package 学习笔记.算法面试40讲.C06_反转链表和判断链表有环.LC206_反转链表;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/2/15 11:02 PM
 * @description
 */
public class Solution {
    /**
     * LC206：反转单链表
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
