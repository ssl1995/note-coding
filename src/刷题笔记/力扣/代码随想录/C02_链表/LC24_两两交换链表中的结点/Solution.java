package 刷题笔记.力扣.代码随想录.C02_链表.LC24_两两交换链表中的结点;

import 学习笔记.读书笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/3/20 18:41
 * @description
 */
public class Solution {
    /**
     * 两两交换链表中的结点
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next;
        // 依次交换pre后面两个节点
        while (pre.next != null && pre.next.next != null) {
            // 必须画图，否则很容易错
            next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            // 步进一位
            pre = cur;
            cur = cur.next;

        }

        return dummy.next;
    }
}
