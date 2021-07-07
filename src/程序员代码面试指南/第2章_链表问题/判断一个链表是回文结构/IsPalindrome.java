package 程序员代码面试指南.第2章_链表问题.判断一个链表是回文结构;

import java.util.Stack;

public class IsPalindrome {

    // （机试方法）方法1：使用栈,将全部数据压入
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法2:使用栈，只压入一半数据
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1.cur作为快指针遍历到数组末尾
        Node cur = head;
        // 2.right指向中间靠右，初始化必为head.next
        Node right = head.next;
        // 3.快慢指针遍历，cur遍历到末尾，right指向中间右边的位置
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        // 4.右边数据入栈
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        // 5.比对左边数据和右边数据
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法3：反转右边链表，最后复原，只使用三个变量
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1.快指针n2,慢指针n1,初始化为head
        // 结束时，慢指针指向中间(奇数个数)，慢指针指向中间靠左位置(偶数个数)
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 2.慢指针n1.next置空，n1反转后半部链表
        n2 = n1.next;
        n1.next = null;
        Node n3;
        // while结束，n1指向末尾节点,n2、n3都为空
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        // 3.n1、n3指向末尾，n2指向头结点，开始遍历判断是否是回文结构
        n3 = n1;
        n2 = head;
        boolean isPalindrome = true;
        // while结束，n1、n2指向null，n3还在末尾节点
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                isPalindrome = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 4.恢复右边链表
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return isPalindrome;
    }

}
