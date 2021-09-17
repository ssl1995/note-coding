package 力扣.剑指Offer.第二版.剑指Offer25_合并两个有序链表;

import 力扣.剑指Offer.utils.ListNode;

public class JZ16 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = list1, q = list2;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        // 是与的关系
        while (p != null && q != null) {
            if (p.val < q.val) {
                pre.next = p;
                pre = p;
                p = p.next;
            } else {
                pre.next = q;
                pre = q;
                q = q.next;
            }
        }
        // 最后谁不为空，指向谁
        pre.next = p != null ? p : q;
        return dummy.next;
    }

}
