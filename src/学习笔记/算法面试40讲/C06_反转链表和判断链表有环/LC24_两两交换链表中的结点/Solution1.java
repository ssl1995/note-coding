package 学习笔记.算法面试40讲.C06_反转链表和判断链表有环.LC24_两两交换链表中的结点;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/2/15 11:21 PM
 * @description
 */
public class Solution1 {
    /**
     * LC24:两两交换链表中的结点
     * 示例：1,2,3,4 反转成 2,1,4,3
     * 迭代
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            temp = node1;
        }
        return dummy.next;
    }
}
