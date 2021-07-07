package 程序员代码面试指南.第1章_栈和队列.用一个栈实现另一个栈的排序;

import java.util.Stack;


public class SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        // 1.使用一个辅助栈，将stack栈中从小到大排序
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            // 2.反过来想，cur>辅助栈顶，辅助栈出栈进原栈
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            // 3.cur<=辅助栈顶，就入辅助栈
            help.push(cur);
        }
        // 4.遍历辅助栈元素，依次进原栈，实现原栈栈顶到栈底从大到小
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void sortStackByStack1(Stack<Integer> stack) {
        // 1.使用一个辅助栈，将stack栈中从小到大排序
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            // 2.反过来想，cur>辅助栈顶，辅助栈出栈进原栈
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            // 3.cur<=辅助栈顶，就入辅助栈
            help.push(cur);
        }
        // 4.遍历辅助栈元素，依次进原栈，实现原栈栈顶到栈底从大到小
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(2);
        stack.add(1);
        System.out.println(stack);
        sortStackByStack(stack);
        System.out.println(stack);

    }
}
