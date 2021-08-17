package 牛客算法课.基础班.课9_递归.Q04_递归逆序栈;

import java.util.Stack;

public class ReverseStackUsingRecursive {

    // Q:递归逆序栈
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getLast(stack);// 递归获取栈底元素
        reverse(stack);// 递归本方法
        stack.push(last);// 回溯，将获得的栈底元素放回栈中
    }


    public static int getLast(Stack<Integer> stack) {
        int pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {
            int last = getLast(stack);
            stack.push(pop); // 回溯,将当前出栈元素放回栈
            return last;// 返回栈底元素
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
