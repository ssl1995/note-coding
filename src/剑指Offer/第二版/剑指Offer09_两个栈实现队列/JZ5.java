package 剑指Offer.第二版.剑指Offer09_两个栈实现队列;

import java.util.Stack;

public class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        push2Pop();
        stack1.push(node);
        push2Pop();
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        push2Pop();
        int pop = stack2.pop();
        push2Pop();
        return pop;
    }

    private void push2Pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }


}
