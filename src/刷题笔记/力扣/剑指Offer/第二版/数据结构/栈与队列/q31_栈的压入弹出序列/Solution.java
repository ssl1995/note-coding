package 刷题笔记.力扣.剑指Offer.第二版.数据结构.栈与队列.q31_栈的压入弹出序列;


import java.util.LinkedList;

public class Solution {

    /**
     * 给一个压入数组和一个弹出数组，判断两者是不是一个栈的压入与弹出序列
     * pushed=[1,2,3,4,5],popped=[4,5,3,2,1]返回true，[4,5,3,1,2]返回false
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 用辅助栈来模拟压栈操作
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            // 辅助栈先存入压栈元素
            stack.push(num);
            // 辅助栈顶等于出栈系列元素，辅助栈出栈，出栈序列遍历指针后移
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        // 如果全部匹配，辅助为空；否则失败
        return stack.isEmpty();
    }
}
