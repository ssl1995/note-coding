package 读书笔记.数据结构By慕课网.链表.练习题.剑指Offer;


import 读书笔记.数据结构By慕课网.工具类.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从头到尾打印链表
 */
public class Offer06 {
    // 栈方法：先进后出的特性
    public int[] reversePrint(ListNode head) {
        // 推荐使用LinkedList来表示栈，别用Stack
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }

    // 递归法
    private ArrayList<Integer> temp = new ArrayList<>();

    public int[] reversePrint1(ListNode head) {
        reList(head);
        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void reList(ListNode head) {
        // 递归结束条件
        if (head == null) {
            return;
        }
        reList(head.next);
        // 递归回溯时，将结点的值添加到list中
        temp.add(head.val);
    }


}
