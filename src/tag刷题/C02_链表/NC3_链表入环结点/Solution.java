package tag刷题.C02_链表.NC3_链表入环结点;

import tag刷题.utils.ListNode;

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

    // 法1：fast指向pHead.next.next
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
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
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // 法2：ListNode fast = pHead
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        // 快指针走2步,慢指针走1步
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // fast重新指向头结点
        fast = pHead;
        // 快指针走1步,慢指针走1步
        while (fast != slow) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
