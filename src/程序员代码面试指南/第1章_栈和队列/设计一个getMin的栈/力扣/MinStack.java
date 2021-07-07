package 程序员代码面试指南.第1章_栈和队列.设计一个getMin的栈.力扣;

import java.util.Stack;

// 力扣155：最小值栈
class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else if (x < getMin()) {
            stackMin.push(x);
        } else {
            stackMin.push(getMin());
        }
        stackData.push(x);
    }

    public void pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        stackMin.pop();
        stackData.pop();
    }

    public int top() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return stackData.peek();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }
}
