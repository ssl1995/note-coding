package 剑指Offer.分类版.C02_链表.剑指Offer18_删除链表结点;


import 剑指Offer.utils.ListNode;

public class Solution {

    // 法1:双指针版
    public ListNode deleteNode1(ListNode head, int val) {
        // 1.判断head是否为待删除结点,不是就初始化cur和pre
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        // 2.初始化pre和cur
        ListNode pre = head;
        ListNode cur = head.next;
        // 3.cur遍历直到cur.val==val结点
        while (cur != null && cur.val != val) {
            pre = cur;
            // 由于cur指向了下一个结点,while条件增加cur!=null
            cur = cur.next;
        }
        // 4.循环跳出,当cur!=null时,肯定指向待删除结点
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }

    // 法2:单指针版
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        // cur遍历到待删除结点的前一个位置
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }
}
