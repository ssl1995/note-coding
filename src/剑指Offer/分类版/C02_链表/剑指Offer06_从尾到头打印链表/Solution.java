package 剑指Offer.分类版.C02_链表.剑指Offer06_从尾到头打印链表;



import 剑指Offer.utils.ListNode;

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
    }

    // 法2:递归法,先理解辅助栈法,体会递归本质这种先进后出的思想
    public int[] reversePrint1(ListNode head) {
        // 存放递归逆序后的值
        List<Integer> temp = new ArrayList<>();
        // 递归:本质上是一个先进后出的栈,temp中存放了逆序后的val
        reverse(head, temp);
        // 将List中的val遍历进一个返回值数组中即可
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void reverse(ListNode node, List<Integer> temp) {
        if (node == null) {
            return;
        }
        reverse(node.next, temp);
        // 下一层递归结束,接受这一层的node.val
        temp.add(node.val);
    }
}
