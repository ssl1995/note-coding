package 刷题笔记.力扣.剑指Offer.第二版.数据结构.链表.q06_从尾到头打印链表;


import 刷题笔记.力扣.utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    /**
     * 题目：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

}
