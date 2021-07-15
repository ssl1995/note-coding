package tag刷题.C05_栈和队列.NC76_两个栈实现队列;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        push2Pop();
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        int res = stack2.pop();
        push2Pop();
        return res;
    }

    private void push2Pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
