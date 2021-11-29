package 剑指Offer.第三版.第4章_链表.q27_回文链表;

import 剑指Offer.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2021/9/27 8:51 上午
 * @description 回文链表
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针，找中间节点：奇数正中间，偶数中间前一个
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 找到后半部分链表的头结点
        ListNode secondHead = slow.next;
        // 如果链表总数是奇数，跳过中间节点，找slow的next.next作为后半部分的头结点
        if (fast.next != null) {
            secondHead = slow.next.next;
        }
        // 慢节点的后继置空，才能反转判断
        slow.next = null;
        return equals(secondHead, reverseList(head));
    }

    // 判断两个链表值是否相同
    private Boolean equals(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    // 反转单链表
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
