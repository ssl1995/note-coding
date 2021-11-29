package 剑指Offer.第二版.第3章_高质量代码.q22_链表倒数第K个节点;

import 剑指Offer.utils.ListNode;

public class JZ14 {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode fast = pHead, slow = pHead;
        while (k > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
