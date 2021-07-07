package 程序员代码面试指南.第1章_栈和队列.设计一个getMin的栈;

import java.util.Stack;

public class Mystack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack1() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newValue) {
        if (stackMin.isEmpty()) {
            stackMin.push(newValue);
        } else if (newValue <= getMin()) {
            stackMin.push(newValue);
        }
        stackData.push(newValue);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = stackData.pop();
        // 由于入栈是<=保证不同步压入，所以这里==就需要重新判断
        if (value == getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }
}
