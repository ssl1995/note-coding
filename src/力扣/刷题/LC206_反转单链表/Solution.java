package 力扣.刷题.LC206_反转单链表;

import 剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2021/12/1 5:40 下午
 * @description
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
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
