package 学习笔记.剑指Offer.第二版.第4章_解决面试题的思路.q30_包含min函数的栈;

import java.util.LinkedList;

public class MinStack {
    /*
     * 方法:data栈入数据,min栈每次只存入<=min栈顶的元素
     */
    /**
     * 栈1：数据栈，正常压入弹出
     */
    private LinkedList<Integer> stack1;

    /**
     * 栈2：辅助栈，栈顶保持栈1中的最小值
     */
    private LinkedList<Integer> stack2;

    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        // 如果栈2空，或者x比栈2顶还小，就压入栈2
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
        // 栈2始终保持与栈1同步压入数据，但是栈2顶保持最小值
        if (x > stack2.peek()) {
            stack2.push(min());
        }
        // 栈1是每次都要压入的
        stack1.push(x);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
