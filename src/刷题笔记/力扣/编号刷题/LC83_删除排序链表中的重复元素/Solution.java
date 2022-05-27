package 刷题笔记.力扣.编号刷题.LC83_删除排序链表中的重复元素;

import 刷题笔记.力扣.utils.ListNode;

public class Solution {
    // 删除重复结点，保留重复结点一次：1->2->2->3 返回 1 ->2->3
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                // cur作为遍历指针，只有前后不相等时，才后移
                cur = cur.next;
            }
        }
        return head;
    }
}
