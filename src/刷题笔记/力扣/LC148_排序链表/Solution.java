package 刷题笔记.力扣.LC148_排序链表;

import 读书笔记.剑指Offer.utils.ListNode;

public class Solution {

    public ListNode sortList(ListNode head) {
        return mergeSortList(head);
    }

    // 归并排序单链表
    private ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMidNode(head);// 找到中点位置：链表奇数长返回中点，偶数长返回中间靠左位置
        ListNode next = middle.next;// 记录中点下一个位置
        middle.next = null;// 切割中点，一定要中间.next置空
        ListNode left = mergeSortList(head);// 以左边的头head开始递归
        ListNode right = mergeSortList(next);// 以右边的头next开始递归
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

    // 找到链表中心：奇数是中点，偶数是中心靠左的位置
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
