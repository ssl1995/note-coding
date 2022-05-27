package 刷题笔记.力扣.热门100.LC148_排序链表;

import 刷题笔记.力扣.utils.ListNode;

public class Solution {
    /**
     * 排序链表
     * 使用归并排序，升序排序
     */
    public ListNode sortList(ListNode head) {
        return mergeSortList(head);
    }

    private ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中点位置：链表奇数长返回中点，偶数长返回中间靠左位置
        ListNode middle = getMidNode(head);
        // 记录中点下一个位置
        ListNode next = middle.next;
        // 切割中点，一定要中间.next置空
        middle.next = null;
        // 以左边的头head开始递归
        ListNode left = mergeSortList(head);
        // 以右边的头next开始递归
        ListNode right = mergeSortList(next);
        // 合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null & right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    /**
     * 找到链表中心：奇数是中点，偶数是中心靠左的位置
     */
    private ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 画图，slow此时就指向奇数中点/偶数靠左的位置
        return slow;
    }

}
