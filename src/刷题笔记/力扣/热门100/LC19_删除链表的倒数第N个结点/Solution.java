package 刷题笔记.力扣.热门100.LC19_删除链表的倒数第N个结点;

import 学习笔记.剑指Offer.utils.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 初始化；fast指针在head，slow在head前一个位置dummy
        ListNode fast = head;
        ListNode slow = dummy;
        // fast一次走1步，先走k步
        while (n > 0) {
            // fast穿过末尾节点,返回null
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
        // 由于slow指向dummy,所以fast要多走一步到达null，才能让slow到达待删除结点前一个位置
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除倒数第k个节点
        slow.next = slow.next.next;
        return dummy.next;
    }


}
