package 剑指Offer.正序版.剑指Offer24_反转链表;


import 剑指Offer.utils.ListNode;

public class Solution {
    // 法1:迭代法
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        // pre只是记录cur的前一个结点,不会使用到任何next结点
        ListNode pre = null;
        while (cur != null) {
            // 一定是先记录cur后一个节点
            ListNode next = cur.next;
            // 从cur开始改变指向
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 法2:递归法
    public ListNode reverseList2(ListNode head) {
        // 1.单个节点或者空节点反转,就是它本身
        if (head == null || head.next == null) {
            return head;
        }
        // 2.递归到链表末尾结束,此时ret为最后一个非空结点,head为倒数第二个非空结点
        ListNode ret = reverseList2(head.next);
        // 3.有倒数第一、倒数第二结点，思考反转过程
        head.next.next = head;// 末尾节点反转指针
        head.next = null;// 倒数第二个节点next判空,供上一层调用
        return ret;
    }


}
