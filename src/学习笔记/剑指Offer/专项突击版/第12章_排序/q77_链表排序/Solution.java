package 学习笔记.剑指Offer.专项突击版.第12章_排序.q77_链表排序;

/**
 * @author SongShengLin
 * @date 2021/11/9 9:14 上午
 * @description
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 采用归并排序的方式，和碧昂两个有序链表
        ListNode head1 = head;
        ListNode head2 = split(head);

        head1 = sortList(head1);
        head2 = sortList(head2);

        return merge(head1, head2);
    }

    // 将head为头的链表分成2部分，返回中间节点后一个节点
    private ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 获取中间节点下一个结点
        ListNode second = slow.next;
        // 中间节点后继判空
        slow.next = null;
        // 返回中间节点下一个结点
        return second;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head1 != null & head2 != null) {
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
        ListNode head = new ListNode(3);
        ListNode head5 = new ListNode(5);
        ListNode head1 = new ListNode(1);
        ListNode head4 = new ListNode(4);
        ListNode head2 = new ListNode(2);
        ListNode head6 = new ListNode(6);

        head.next = head5;
        head5.next = head1;
        head1.next = head4;
        head4.next = head2;
        head2.next = head6;


        Solution solution = new Solution();
        solution.sortList(head);
    }
}
