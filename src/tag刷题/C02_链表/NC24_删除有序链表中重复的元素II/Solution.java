package tag刷题.C02_链表.NC24_删除有序链表中重复的元素II;

import tag刷题.utils.ListNode;

public class Solution {
    // 题目：给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {// 遇到相邻两个节点值相同的，因为链表升序，temp记录后面不同的第一个结点
                ListNode temp = cur.next;
                while (temp != null && temp.val == cur.val) {
                    temp = temp.next;
                }
                // 删除相同节点，cur指向不同的第一个结点temp
                pre.next = temp;
                cur = temp;
            } else {// 没遇到相邻的相同值结点，后移pre和cur即可
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
