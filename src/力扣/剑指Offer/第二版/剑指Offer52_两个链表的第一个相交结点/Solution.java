package 力扣.剑指Offer.第二版.剑指Offer52_两个链表的第一个相交结点;


import 力扣.剑指Offer.utils.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        // len记录两个链表长度差值
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
        // 长度差可能为负,len取绝对值
        len = Math.abs(len);
        // 由于cur1指向长的，先走len步
        while (len > 0) {
            cur1 = cur1.next;
            len--;
        }
        // cur1和cur2再一起走
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
