package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q52_两个链表的第一个相交结点.练习;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/1/15 11:46 AM
 * @description
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int len = 0;
        while (cur1.next != null) {
            cur1 = cur1.next;
            len++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            len--;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = len > 0 ? headA : headB;
        cur2 = cur1 == headA ? headB : headA;
        len = Math.abs(len);
        while (len > 0) {
            cur1 = cur1.next;
            len--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
