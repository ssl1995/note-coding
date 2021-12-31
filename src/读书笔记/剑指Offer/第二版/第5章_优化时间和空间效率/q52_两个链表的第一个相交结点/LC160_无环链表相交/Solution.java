package 读书笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q52_两个链表的第一个相交结点.LC160_无环链表相交;

import 读书笔记.剑指Offer.utils.ListNode;

public class Solution {
    /**
     * 与q52相同，无环链表相交是问两个单向链表的相交第一个结点
     * NC3是问单个链表的入环结点，问题参数不是一个东西
     */
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 1.遍历两个链表，同时记录长度差值和尾结点是否相同
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        // 记录差值
        int len = 0;
        while (cur1 != null) {
            len++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len--;
            cur2 = cur2.next;
        }
        // 两个无环链表,如果末尾节点不等，就肯定不相交
        if (cur1 != cur2) {
            return null;
        }
        // 2.让长链表先走两个链表的长度差的绝对值步数
        // cur1指向长的头结点，cur2指向慢的头结点
        cur1 = len > 0 ? head1 : head2;
        cur2 = (cur1 == head1) ? head2 : head1;
        // 注意:差值此时取绝对值
        len = Math.abs(len);
        while (len != 0) {
            len--;
            cur1 = cur1.next;
        }
        // 3.此时两个节点同时走,相交时就是无环链表入环结点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
