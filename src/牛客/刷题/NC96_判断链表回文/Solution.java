package 牛客.刷题.NC96_判断链表回文;

import 剑指Offer.utils.ListNode;

import java.util.LinkedList;

public class Solution {
    // 法1:栈存全部
    public boolean isPail1(ListNode head) {
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
            if (cur.val != stack.pop()) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    // 法2:栈存右半部分
    public boolean isPail2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        // slow指向奇数中心 或 偶数中心靠左的位置
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 栈中只用存右半部分，和左半部分比较即可
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    // 法3:三个变量，不需要栈，速度最快
    public boolean isPail3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // slow指向中心位置
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast指向右半部分第一个位置
        fast = slow.next;
        slow.next = null;// 中心位置后继置空
        ListNode next = null;// 反转记录后继结点
        while (fast != null) {
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        next = slow;// slow指向末尾节点，next指向它
        fast = head;// fast指向头结点
        boolean res = true;// 因为右半部分要反转回来，只能先记录返回值
        while (fast != null && next != null) {// 模拟栈的过程：fast和next指向比较
            if (fast.val != next.val) {
                res = false;
                break;
            }
            fast = fast.next;
            next = next.next;
        }
        // 比较完毕，右半部分反转回去
        fast = slow;// fast指向末尾=遍历遍历指针
        slow.next = null;// slow=pre，记录前面
        while (fast != null) {// 反转逻辑和前面一样
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        return res;
    }

}
