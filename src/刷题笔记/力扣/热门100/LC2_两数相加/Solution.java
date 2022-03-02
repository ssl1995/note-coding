package 刷题笔记.力扣.热门100.LC2_两数相加;

import 学习笔记.剑指Offer.utils.ListNode;

public class Solution {

    /**
     * 两数相加
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        int carryNum = 0;
        while (head1 != null || head2 != null) {
            // 这一轮加起来的数先继承上一轮的进位值
            int sumNum = carryNum;
            if (head1 != null) {
                sumNum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sumNum += head2.val;
                head2 = head2.next;
            }
            cur.next = new ListNode(sumNum % 10);
            carryNum = sumNum / 10;
            cur = cur.next;
        }
        // 如果还存在进位，就添加到链表末尾
        if (carryNum == 1) {
            cur.next = new ListNode(carryNum);
        }
        // 返回哑结点.next
        return dummyNode.next;
    }

}
