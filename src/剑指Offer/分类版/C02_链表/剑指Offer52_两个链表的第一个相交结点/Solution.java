package 剑指Offer.分类版.C02_链表.剑指Offer52_两个链表的第一个相交结点;


import 剑指Offer.utils.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        // 记录两个链表差值
        int len = 0;
        while (cur1.next != null) {
            len++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            len--;
            cur2 = cur2.next;
        }
        // 如果两个遍历指针遍历到末尾不相等,两个链表必不交
        if (cur1 != cur2) {
            return null;
        }
        // cur1指向较长的链表
        cur1 = (len > 0 ? headA : headB);
        // cur2指向较短的链表
        cur2 = (cur1 == headA ? headB : headA);
        // len长度差可能为负
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
