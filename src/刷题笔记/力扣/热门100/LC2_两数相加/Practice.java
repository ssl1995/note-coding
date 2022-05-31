package 刷题笔记.力扣.热门100.LC2_两数相加;

import 刷题笔记.力扣.utils.ListNode;

/**
 * @author SongShengLin
 * @date 2022/5/31 23:20
 * @description
 */
public class Practice {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;

    }
}
