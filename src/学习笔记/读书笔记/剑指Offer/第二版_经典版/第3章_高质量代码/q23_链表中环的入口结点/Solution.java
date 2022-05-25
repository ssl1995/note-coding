package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第3章_高质量代码.q23_链表中环的入口结点;

import 学习笔记.读书笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2021/12/15 9:17 AM
 * @description
 */
public class Solution {
    /**
     * 判断链表是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        // 初始化：快指针在next.next,慢指针在next上
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
