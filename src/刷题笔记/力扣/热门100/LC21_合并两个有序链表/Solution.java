package 刷题笔记.力扣.热门100.LC21_合并两个有序链表;


import 刷题笔记.力扣.utils.ListNode;

public class Solution {
    /**
     * 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 没有遍历完的链表直接挂在最后
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
