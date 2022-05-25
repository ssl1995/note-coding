package 刷题笔记.力扣.代码随想录.C02_链表.LC203_移除链表元素;

import 学习笔记.读书笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/3/19 08:46
 * @description
 */
public class Solution {
    /**
     * 移除链表元素
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                // 移动pre指针后续
                pre.next = cur.next;
            } else {
                // 移动指针
                pre = cur;
            }
            cur = cur.next;
        }
        // 返回虚拟头结点的后继
        return dummy.next;
    }
}
