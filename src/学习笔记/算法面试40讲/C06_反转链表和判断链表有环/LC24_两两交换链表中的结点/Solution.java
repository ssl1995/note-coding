package 学习笔记.算法面试40讲.C06_反转链表和判断链表有环.LC24_两两交换链表中的结点;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/2/15 10:44 PM
 * @description
 */
public class Solution {

    /**
     * LC24:两两交换链表中的结点
     * 示例：1,2,3,4 反转成 2,1,4,3
     * 递归
     */
    public ListNode swapPairs(ListNode head) {
        // head||next有一个为空，无法交换，返回head
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        // head.next指向后，后为next.next
        head.next = swapPairs(next.next);
        // next后继指向head
        next.next = head;
        return next;
    }
}
