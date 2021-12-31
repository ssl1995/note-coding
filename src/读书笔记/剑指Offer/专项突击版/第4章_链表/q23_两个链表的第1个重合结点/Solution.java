package 读书笔记.剑指Offer.专项突击版.第4章_链表.q23_两个链表的第1个重合结点;

import 读书笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2021/9/23 9:04 上午
 * @description 两个链表的第1个重合结点
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 记录两个链表长度
        int count1 = getListCount(headA);
        int count2 = getListCount(headB);
        // 计算长度差的绝对值
        int delta = Math.abs(count1 - count2);
        // 快指针指向长度长的；慢指针指向长度短的
        ListNode fast = count1 > count2 ? headA : headB;
        ListNode slow = count1 > count2 ? headB : headA;
        // 快指针先走长度差这么长
        while (delta > 0) {
            fast = fast.next;
            delta--;
        }
        // 然后快慢指针一起走，最后相交的就是两个链表第一个相交结点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private int getListCount(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
