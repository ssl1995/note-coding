package tag刷题.C05_栈和队列.剑指Offer30_包含min函数的栈;

import java.util.LinkedList;

public class MinStack {
    // 方案:data栈入数据,min栈每次只存入<=min栈顶的元素
    private LinkedList<Integer> dataStack;
    private LinkedList<Integer> minStack;

    public MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        dataStack.push(x);
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("MinStack is null,not pop()");
        }
        int pop = dataStack.pop();
        if (pop == min()) {
            minStack.pop();
        }
    }

    public int top() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("MinStack is null,not top()");
        }
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("MinStack is null,not min()");
        }
        return minStack.peek();
    }
}
