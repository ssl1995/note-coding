package 学习笔记.剑指Offer.第二版.第2章_面试需要的基础知识.q06_从尾到头打印链表;


import 学习笔记.剑指Offer.utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 法1:辅助栈
    public int[] reversePrint(ListNode head) {
        // LinkedList继承了队列、栈,可以使用栈的push,pop的API
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
//        return stack.stream().mapToInt(i -> i).toArray();
    }

    // 法2:递归法,先理解辅助栈法,体会递归本质这种先进后出的思想
    public int[] reversePrint1(ListNode head) {
        // temp存放倒数第一个链表值、倒数第二个链表值...
        List<Integer> temp = new ArrayList<>();
        // 递归：每访问到一个结点时，先递归保存它后面的值
        reverse(head, temp);
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
//        return temp.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 每访问到node，用temp保存它后面的值
     */
    private void reverse(ListNode node, List<Integer> temp) {
        if (node == null) {
            return;
        }
        reverse(node.next, temp);
        temp.add(node.val);
    }
}
