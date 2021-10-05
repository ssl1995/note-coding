package 读书笔记.剑指Offer.第三版.第4章_链表.q21_删除倒数第k个节点;

import 读书笔记.剑指Offer.utils.ListNode;

/**
 * @author songshenglin
 * @date 2021/9/21 10:40
 * @description
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = dummy;
        // fast先走n步
        while (n > 0) {
            // fast==null，说明n过大，返回null
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
        // 由于slow指向dummy,所以fast要多走一步到达null，才能让slow到达待删除结点前一个位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        // 返回头结点
        return dummy.next;
    }
}
