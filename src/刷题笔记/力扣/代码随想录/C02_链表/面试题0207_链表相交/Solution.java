package 刷题笔记.力扣.代码随想录.C02_链表.面试题0207_链表相交;

import 学习笔记.读书笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/3/20 18:58
 * @description
 */
public class Solution {
    /**
     * 链表相交问题
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 计算两个节点的差值
        int len = 0;
        ListNode cur1 = headA;
        while (cur1 != null) {
            cur1 = cur1.next;
            len++;
        }
        cur1 = headB;
        while (cur1 != null) {
            cur1 = cur1.next;
            len--;
        }
        // cur1指向长的头结点，cur2指向短的头结点
        cur1 = len > 0 ? headA : headB;
        ListNode cur2 = cur1 == headA ? headB : headA;
        // cur1先走差值步
        len = Math.abs(len);
        while (len > 0) {
            cur1 = cur1.next;
            len--;
        }
        // 然后两者同时走，相遇时为相交结点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }
}
