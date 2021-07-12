package 牛客算法课.基础班.课4_链表.Q03_判断链表是否是回文;


import 牛客算法课.utils.ListNode;

import java.util.LinkedList;

public class IsPalindrome {

    // 法1:栈记录全部数据
    public boolean isPalindrome1(ListNode head) {
        // 链表为null或只有头结点,是返回true
        if (head == null || head.next == null) {
            return true;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (cur.val != value) {
                return false;
            } else {
                cur = cur.next;
            }
        }
        return true;
    }

    // 法2:栈记录一半数据
    public boolean isPalindrome2(ListNode head) {
        // 链表为null或只有头结点,是返回true
        if (head == null || head.next == null) {
            return true;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        // 快慢指针,让slow指向中间位置(奇数)/中间第一个位置(偶数)
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow后半部分入栈
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        // 遍历前半部,与栈中的后半部分比对
        fast = head;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (fast.val != value) {
                return false;
            } else {
                fast = fast.next;
            }
        }
        return true;
    }

    // 法3:快慢指针
    public static boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1.快指针n2,慢指针n1,初始化为head
        ListNode n1 = head;
        ListNode n2 = head;
        // 结束时，慢指针指向中间(奇数个数)，慢指针指向中间靠左位置(偶数个数)
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 2.慢指针n1指向中点,让后半部分逆序
        n2 = n1.next;// n2:cur遍历指针
        n1.next = null;// n1:相当于pre指针
        ListNode n3;// n3:记录n2的next
        // 反转单链表
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        // 循环结束:n1指向末尾结点,n2,n3越界
        // 3.判断是否回文结构
        n3 = n1;// n3:指向末尾
        n2 = head;// n2:遍历前半部分链表
        boolean isPalindrome = true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                isPalindrome = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 循环结束:n1,n2指向中间位置,n3指向末尾节点
        // 4.恢复后半部分链表
        n1 = n3.next;// n1:指向倒数第二个节点=遍历指针
        n3.next = null;// 末尾节点next置空
        // 反转后半部分链表
        while (n1 != null) {
            n2 = n1.next;// n2:记录n1的next
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return isPalindrome;
    }

}
