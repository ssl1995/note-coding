package 力扣.LC2_两数相加;

import 剑指Offer.utils.ListNode;

public class Solution {
    // 题目：l1 = [2,4,3], l2 = [5,6,4]，返回[7,0,8]
    // 注意：NC40两个链表相加，是正序相加返回正序，比这题难一点
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        int carryNum = 0;// 记录进位值
        while (head1 != null || head2 != null) {
            int sumNum = carryNum;// 这一轮加起来的数先继承上一轮的进位值
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
        if (carryNum == 1) {// 如果还存在进位，就添加到链表末尾
            cur.next = new ListNode(carryNum);
        }
        // 返回哑结点.next
        return dummyNode.next;
    }

}
