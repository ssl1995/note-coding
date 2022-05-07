package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第2章_面试需要的基础知识.q06_从尾到头打印链表;


import 学习笔记.读书笔记.剑指Offer.utils.ListNode;

import java.util.LinkedList;

public class Solution {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
     */
    public int[] reversePrint(ListNode head) {
        // LinkedList继承了队列、栈,可以使用栈的push,pop的API
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

}
