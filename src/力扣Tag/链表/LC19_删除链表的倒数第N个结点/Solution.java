package 力扣Tag.链表.LC19_删除链表的倒数第N个结点;

import 力扣Tag.utils.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        // 使用dummy:pre在head的前一个位置,走k步后到达待删除结点的前一个位置
        ListNode pre = dummy;
        // fast先走k步
        while (n > 0) {
            // fast穿过末尾节点,返回null
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
        // fast和pre同时走,直到fast越过末尾节点,pre到达待删除结点的前一个位置
        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
        }
        // 删除倒数第k个节点
        pre.next = pre.next.next;
        return dummy.next;
    }


}
