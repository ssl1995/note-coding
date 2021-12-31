package 学习笔记.牛客算法课.中级班.课2.Q04_利用栈排序栈中数据;

import java.util.Stack;

public class StackSortStack {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!temp.isEmpty() && cur > temp.peek()) {
                stack.push(temp.pop());
            }
            temp.push(cur);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sortStackByStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
