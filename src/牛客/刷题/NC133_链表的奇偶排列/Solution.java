package 牛客.刷题.NC133_链表的奇偶排列;

import 剑指Offer.utils.ListNode;

public class Solution {
    // NC133和LC328同题
    // 条件：{1,4,6,3,7}，返回：{1,6,7,4,3}(索引从1开始，返回奇数在前结点)
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先记录偶数头结点
        ListNode evenHead = head.next;
        ListNode odd = head;// 奇数指向第一个结点
        ListNode even = head.next;// 偶数指向第二个节点
        // while结束条件是初始化靠后的even结点先来到null，或后继
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // while跳出，让奇数odd末尾指向偶数even的头
        odd.next = evenHead;
        return head;
    }
}
