package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第4章_链表.q26_重排链表;

import 刷题笔记.力扣.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2021/9/26 10:15 上午
 * @description 链表重排
 */
public class Solution {
    // 链表重排
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 找到中间节点：奇数在正中间，偶数在靠左的位置
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 中间链表断开，形成前后两个链表
        ListNode temp = slow.next;
        slow.next = null;
        // 连接前后两个链表
        link(head, reverseList(temp), dummy);
    }

    // 连接前后两个链表
    private void link(ListNode node1, ListNode node2, ListNode dummy) {
        ListNode pre = dummy;
        while (node1 != null && node2 != null) {
            ListNode temp = node1.next;

            pre.next = node1;
            node1.next = node2;
            pre = node2;

            node2 = node2.next;
            node1 = temp;
        }
        // 前半链表长度要保证>=后半链表，所以只用判断node1，node2不用判断
        if (node1 != null) {
            pre.next = node1;
        }
    }

    // 反转单链表
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
