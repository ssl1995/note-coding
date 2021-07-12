package tag刷题.链表.LC142_环形链表II;

import tag刷题.utils.ListNode;

public class Solution {
    /*
      为什么fast在遇到slow后,要重新指向head?
          假设fast走f步,slow走s步,第一个入环结点前有a个节点,环形有b个节点
            显然f = 2s;并且f = s + nb(n是慢指针在环里转的圈数)
            两式相等,推出:s=nb,f=2nb,说明快指针走了2个环周长,慢指针走了1个环周长
          再假设,从head到第一个环结点走的步数:k=a+nb(n从0开始) 结合 s=nb
            推出: s需要再走a步就到达入环结点,所以fast重新指向head走到入环结点就是a步
     */

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        // 快指针走2步,慢指针走1步
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast重新指向头结点
        fast = head;
        // 快指针走1步,慢指针走1步
        while (fast != slow) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
