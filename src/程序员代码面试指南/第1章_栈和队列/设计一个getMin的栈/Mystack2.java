package 程序员代码面试指南.第1章_栈和队列.设计一个getMin的栈;

import java.util.Stack;

public class Mystack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack2() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newValue) {
        if (stackMin.isEmpty()) {
            stackMin.push(newValue);
        } else if (newValue < getMin()) {
            stackMin.push(newValue);
        } else {
            stackMin.push(getMin());
        }
        stackData.push(newValue);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }
}
