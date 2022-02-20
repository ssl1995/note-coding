package 学习笔记.算法面试40讲.C05_数组和链表.C06_反转链表和判断链表有环.LC25_k个一组反转链表;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/2/15 11:46 PM
 * @description
 */
public class Solution {
    /**
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head, next;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        // 整个链表有len/k子块需要翻转
        for (int i = 0; i < len / k; i++) {
            // 单个子系列中，需要翻转k-1次
            for (int j = 0; j < k - 1; j++) {
                // 这里翻转的过程，需要自己画图模拟头插入
                // 初始化：pre指向cur前一个，cur从需要反转的头结点开始，next记录cur后继结点
                //(1)记录cur后继结点
                next = cur.next;

                //(2)中间节点cur指向后继的后继
                cur.next = next.next;
                //(3)next后继指向子序列的头结点,不是指向cur
                next.next = pre.next;
                //(4)哑结点后继执行next
                pre.next = next;
            }
            // 一个字块更新完，移动pre和cur
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
