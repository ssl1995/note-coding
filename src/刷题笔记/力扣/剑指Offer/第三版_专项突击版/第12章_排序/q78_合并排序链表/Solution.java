package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第12章_排序.q78_合并排序链表;

/**
 * @author SongShengLin
 * @date 2021/11/9 10:57 下午
 * @description
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;

        ListNode head1 = mergeList(lists, left, mid);
        ListNode head2 = mergeList(lists, mid + 1, right);

        return merge(head1, head2);
    }


    private ListNode merge(ListNode head1, ListNode head2) {
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

}
