package 刷题笔记.力扣.热门100.LC160_相交链表;

import 刷题笔记.力扣.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/6/18 16:29
 * @description
 */
public class Solution {

    /**
     * 相交链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return headA == null ? headB : headA;
        }

        ListNode cur1 = headA;
        ListNode cur2 = headB;

        int n = 0;
        while (cur1 != null) {
            cur1 = cur1.next;
            n++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            n--;
        }

        // 特殊判断
        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? headA : headB;
        cur2 = cur1 == headA ? headB : headA;
        n = Math.abs(n);

        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
