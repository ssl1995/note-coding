package 刷题笔记.力扣.剑指Offer.第二版_经典版.第5章_优化时间和空间效率.q52_两个链表的第一个相交结点.NC3_链表入环结点;

import 刷题笔记.力扣.utils.ListNode;

public class Solution {

    /**
     * 返回单链表的入环结点
     * 假设环前面有a个节点，环中有b个节点，快指针走f步，慢指针走s步
     * 证明，为什么快指针第一次相遇慢指针后，要重回头结点，并且再次相遇慢指针后，必为入环结点
     * 快指针一次走2步，慢指针一次走1步，必有 f = 2s，以及f = s + nb(n>=0,n是环中循环的次数)
     * 则推出，s=nb,等式两边加上a则有 a+s = a+nb = 从头结点重新遍历到入环结点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        // 快指针走2步,慢指针走1步
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast重新指向头结点
        fast = pHead;
        // 快指针走1步,慢指针走1步
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
