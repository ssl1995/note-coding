package tag刷题.C02_链表.NC21_链表指定区间反转;

import tag刷题.utils.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // pre从dummy走m步，到达第m个节点的前驱
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // cur从第m个节点开始遍历
        head = pre.next;
        ListNode next;
        for (int i = m; i < n; i++) {
            // 每一轮反转只反转cur和next指向这两个节点，m到n节点，需要反转n-m次
            // 每一次都让next接在pre后面，相当于头插法，head不移动
            next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
