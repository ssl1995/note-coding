package 牛客.刷题.NC50_链表中的结点每k个翻转;

import 剑指Offer.utils.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head, next;
        int len = 0;// 计算链表长度
        while (head != null) {
            len++;
            head = head.next;
        }
        for (int i = 0; i < len / k; i++) {// 整个链表有len/k子块需要翻转
            for (int j = 0; j < k - 1; j++) {// 单个子系列中，需要翻转k-1次
                // 这里翻转的过程，需要自己画图模拟头插入
                // 初始化：pre指向cur前一个，cur从需要反转的头结点开始，next记录cur后继结点
                next = cur.next;//(1)记录cur后继结点
                cur.next = next.next;//(2)中间节点cur指向后继的后继
                next.next = pre.next;//(3)next后继指向子序列的头结点,不是指向cur
                pre.next = next;//(4)哑结点后继执行next
            }
            // 一个子序列更新完，移动pre和cur
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
