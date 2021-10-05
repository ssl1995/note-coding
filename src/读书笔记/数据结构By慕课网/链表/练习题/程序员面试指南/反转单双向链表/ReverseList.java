package 读书笔记.数据结构By慕课网.链表.练习题.程序员面试指南.反转单双向链表;


import 读书笔记.数据结构By慕课网.工具类.DoubleNode;
import 读书笔记.数据结构By慕课网.工具类.ListNode;


public class ReverseList {
    // 反转单向链表：迭代法
    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        // 由于cur遍历到末尾.next，所以返回pre
        return pre;
    }

    // 反转双向链表：迭代法
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 单向打印链表2：递归实现
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 返回的头结点 = 最后递归返回的最后一个结点
        ListNode res = reverseList2(head.next);
        // 递归反转
        head.next.next = head;
        head.next = null;
        return res;
    }


}
