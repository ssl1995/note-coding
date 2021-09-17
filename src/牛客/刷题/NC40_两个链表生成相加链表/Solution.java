package 牛客.刷题.NC40_两个链表生成相加链表;

import 力扣.剑指Offer.utils.ListNode;

public class Solution {

    // 题目：链表1为9->3->7，链表2为6->3，最后生成新的结果链表是正序相加的：1->0->0->0
    // 方法：先反转再加
    public ListNode addInList(ListNode head1, ListNode head2) {
        // 先反转两个链表，使得能从低位开始进行加
        head1 = reverseList(head1);
        head2 = reverseList(head2);
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
        // 反转哑结点.next，返回
        return reverseList(dummyNode.next);
    }

    // 反转单链表
    private ListNode reverseList(ListNode root) {
        ListNode cur = root;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
