package 慕课网数据结构.排序.insertSort.leetcode147;

public class Solution {
    // 问题：链表的插入排序
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 哑结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            // 依然有序,pre后移
            if (pre.val <= cur.val) {
                pre = pre.next;
            } else {
                // 倒序,初始化一个lastPre指向哑结点,从头找<=cur.val的最后一个结点的前一个结点
                ListNode lastPre = dummyNode;
                while (lastPre.next.val <= cur.val) {
                    lastPre = lastPre.next;
                }
                // 交换lastPre,pre,cur
                pre.next = cur.next;
                cur.next = lastPre.next;
                lastPre.next = cur;
            }
            // cur移动到pre后面
            cur = pre.next;
        }
        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
