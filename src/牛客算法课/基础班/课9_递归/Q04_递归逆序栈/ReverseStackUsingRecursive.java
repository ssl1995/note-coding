package 牛客算法课.基础班.课9_递归.Q04_递归逆序栈;

import java.util.Stack;

public class ReverseStackUsingRecursive {

    // Q:递归逆序栈
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // 通过某递归方法:获取当前栈底元素,其余元素不变
        int i = getAndRemoveLastElement(stack);
        // 递归本方法:重复本方法
        reverse(stack);
        // 回溯,最后一轮获取的栈底元素=原先的栈顶,放回栈中
        stack.push(i);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            // 回溯,将当前出栈元素放回栈
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }

}
