package 读书笔记.数据结构By慕课网.链表.练习题.程序员面试指南.回文字符串;


import 读书笔记.数据结构By慕课网.工具类.ListNode;

import java.util.Stack;

public class IsPalindrome {

    // 方法1：使用栈，额外空间N
    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法2:利用栈存存一半链表,快慢指针
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;
        ListNode small = head.next;
        // 循环结束，fast指向末尾，small指向中间节点（奇数）or中间节点后一个节点（偶数）
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            small = small.next;
        }
        while (small != null) {
            stack.push(small);
            small = small.next;

        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法3:不需要额外空间
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        // 1.n1指向中间节点，n2指向末尾节点
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        ListNode n3 = null;
        // 2.遍历反转后半部分的节点
        n2 = n1.next;
        n1.next = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;// 遍历结束,n1指向链表末尾
            n2 = n3;
        }
        //3.检查回文
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n2 != null && n1 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n2 = n2.next;
            n1 = n1.next;
        }
        // 4.反转回去
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
