package tag刷题.C02_链表.NC53_删除链表的倒数第n个节点;

import tag刷题.utils.ListNode;

public class Solution {
    // 题目：删除链表的倒数第n个节点(n从1开始计数)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        pre = dummy;
        // 快指针先走n步，注意k只能到1
        while (n >= 1) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
        // 慢指针指向head，快指针相差k个，两个一起走
        while (fast != null) {
            fast = fast.next;
            pre = slow;// pre每次都记录slow的前一个位置
            slow = slow.next;
        }
        // 此时slow指向倒数第n个节点，pre为其前一个结点
        // 删除倒数第k个节点
        pre.next = slow.next;
        return dummy.next;
    }
}
