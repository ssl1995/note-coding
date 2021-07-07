package 程序员代码面试指南.第2章_链表问题.两个单链表相交的问题.力扣;

import java.util.HashSet;

public class LeetCode160 {
    // 问题：无环的两个单链表求相交结点：推荐记双指针法
    // 方法1：记录差值的长度方法
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 1.遍历两个链表，同时记录长度差值
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        // 记录差值
        int n = 0;
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            n--;
            cur2 = cur2.next;
        }
        // 2.如果末尾节点不等，就肯定不相交
        if (cur1 != cur2) {
            return null;
        }
        // 3.cur1指向长的头结点，cur2指向慢的头结点
        cur1 = n > 0 ? headA : headB;
        cur2 = (cur1 == headA) ? headB : headA;
        // 差值此时取绝对值
        n = Math.abs(n);
        // 4.让长的先遍历len长-len短的距离
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        // 5.最后2个同时遍历，走到末尾就是相交结点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 方法2:双指针法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        // 两个指针遍历到链表末尾，就重新执行对方的头结点遍历，直到相遇为止
        // 如果相交，cur1==cur2==第一个相交结点,跳出循环
        // 如果没有相交，cur1==cur2==null，跳出循环
        while (cur1 != cur2) {
            cur1 = (cur1 == null) ? headB : cur1.next;
            cur2 = (cur2 == null) ? headA : cur2.next;
        }
        return cur1;
    }

    // 方法3：set法
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
