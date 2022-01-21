package 刷题笔记.力扣.热门100.LC23_合并K个升序链表;

import 学习笔记.剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/1/21 8:31 AM
 * @description
 */
public class Solution {

    /**
     * 合并K个升序链表
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int left, int right) {
        // 返回的是一个链表的头结点
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;

        ListNode head1 = mergeList(lists, left, mid);
        ListNode head2 = mergeList(lists, mid + 1, right);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node4;
        lists[2] = node7;
        printListNode(solution.mergeKLists(lists));
    }

    private static void printListNode(ListNode head) {
        ListNode cur = head;
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        while (cur.next != null) {
            buffer.append(cur.val).append(" ");
            cur = cur.next;
        }
        buffer.append(cur.val).append("]");
        System.out.println(buffer);
    }
}
