package 剑指Offer.第二版.剑指Offer52_两个链表的第一个相交结点.NC3_链表入环结点;

import 剑指Offer.utils.ListNode;

public class Solution {
    /*
          为什么fast在遇到slow后,要重新指向head?
            1.假设fast走了f步,slow走了s步,第一个入环结点前有a个节点,环形有b个节点，链表长度为a+b
            (1)fast比slow每次都多走一步，所以fast走的步数是slow步数的2倍，即f=2s
            (2)fast比slow多走了n个环的长度，所以fast=s+nb
            (3)推出：s=nb,f=2nb,即是s走了n圈长的步数，f走了2n圈长的步数
            2.再假设,从head到第一个环结点走的步数:k=a+nb(n从0开始)
            (1)结合s=nb，所以k=a+s，说明slow再走a步就到达第一个入环结点
            (2)为了和slow走a步到入环结点，让fast在第一次相遇后重新指向head，也同样走a步到达入环结点

     */

    // 法:判断链表是否有环，有环就返回入环结点
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
