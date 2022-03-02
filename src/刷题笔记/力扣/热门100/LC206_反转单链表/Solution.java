package 刷题笔记.力扣.热门100.LC206_反转单链表;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2021/12/1 5:40 下午
 * @description
 */
public class Solution {

    /**
     * 反转单链表
     */
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
