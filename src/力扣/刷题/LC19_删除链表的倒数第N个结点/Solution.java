package 力扣.刷题.LC19_删除链表的倒数第N个结点;

import 剑指Offer.utils.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = dummy;
        // fast先走k步
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
