package 力扣.剑指Offer.第三版.第4章_链表.q25_链表中的数字相加;

import 力扣.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2021/9/23 9:33 上午
 * @description
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        return null;
    }

    private ListNode addReversed(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
        }
        return null;
    }

    private ListNode reverseList(ListNode head) {
        // pre = 待反转结点的前一个结点，最后返回它
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
