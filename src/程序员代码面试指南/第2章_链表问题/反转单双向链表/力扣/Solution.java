package 程序员代码面试指南.第2章_链表问题.反转单双向链表.力扣;

public class Solution {
    // 反转单链表:递归法
    public ListNode reverseList(ListNode head) {
        // 1.head遍历链表到末尾，就能想到递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 2.开始递归，得出末尾节点res，返回的就是res
        ListNode res = reverseList(head.next);
        // 3.上一句跳出，此时的head指向倒数第二个节点，反转链表指针
        head.next.next = head;
        head.next = null;
        return res;
    }

    // 反转单链表:迭代法
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
