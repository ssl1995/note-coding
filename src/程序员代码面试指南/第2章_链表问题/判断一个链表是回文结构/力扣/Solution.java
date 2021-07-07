package 程序员代码面试指南.第2章_链表问题.判断一个链表是回文结构.力扣;


import java.util.Stack;

// 力扣234
public class Solution {

    // 方法1：使用栈,将全部数据压入
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

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1.cur作为快指针遍历到数组末尾
        ListNode cur = head;
        // 2.right初始化为head.next,
        ListNode right = head.next;
        // 3.快慢指针遍历，cur遍历到末尾，right指向中间右边的位置
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        // 4.右边数据入栈
        Stack<ListNode> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        // 5.比对左边数据和右边数据
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1.n1指向中间节点靠左，初始化为head
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 2.n1=pre,n2遍历右边，n3=next
        n2 = n1.next;
        n1.next = null;
        ListNode n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        // 3.while结束，n1指向末尾节点,
        // 4.将n3指向n1,n2指向head
        n3 = n1;
        n2 = head;
        boolean res = true;
        // 5.n1从链表末尾遍历、n2从head开始遍历
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 6.恢复右边链表,n3=pre,n1遍历，n2=next
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
