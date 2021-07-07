package 程序员代码面试指南.第2章_链表问题.单链表和双链表删除倒数第K个节点.力扣;

public class Solution {
    // 剑指 Offer 22. 链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 1.遍历单链表，k值-1
        ListNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        // 2.k=0，说明头结点就是待删除结点
        if (k == 0) {
            return head;
        }
        // 3.k<0，说明存在待删除结点
        if (k < 0) {
            // 4.从头开始遍历，k+1直到k=0
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            // 5.k=0，就是删除结点的前一个结点
            return cur.next;
        }
        return null;
    }

    // 剑指 Offer 18. 删除链表的节点
    public ListNode deleteNode(ListNode head, int val) {
        // 处理特殊情况，待删除的是头结点的情况
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
