package 刷题笔记.力扣.热门100.LC2_两数相加;

import 刷题笔记.力扣.utils.ListNode;

public class Solution {

    /**
     * 两数相加
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // 设计链表操作，虚拟头结点是个好习惯
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        // 记录进位信息
        int carry = 0;

        while (head1 != null || head2 != null) {
            // 这一轮加起来的数先继承上一轮的进位值
            int sum = carry;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            // 和算完，立马更新进位信息
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        // 边界：最低位如果还存在进位，就添加到链表末尾
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        // 返回哑结点.next
        return dummyNode.next;
    }

}
