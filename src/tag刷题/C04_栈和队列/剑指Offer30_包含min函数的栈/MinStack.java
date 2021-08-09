package tag刷题.C04_栈和队列.剑指Offer30_包含min函数的栈;

import java.util.LinkedList;

public class MinStack {
    // 方案:data栈入数据,min栈每次只存入<=min栈顶的元素
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    // s1和s2非同步压入
    public void push(int x) {
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
        stack1.push(x);
    }

    public void pop() {
        int pop = stack1.pop();
        if (pop == min()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
