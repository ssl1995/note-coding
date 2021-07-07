package 程序员代码面试指南.第1章_栈和队列.两个栈组成的队列.力扣;

import java.util.Stack;

// 力扣232
class MyQueue1 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;//指向队首元素

    // 栈实现队列方法2：利用front指向队首元素
    public MyQueue1() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }


    public int pop() {
        int res = s1.pop();
        if (!s1.isEmpty()) {
            front = s1.peek();
        }
        return res;
    }


    public int peek() {
        return front;
    }


    public boolean empty() {
        return s1.isEmpty();
    }
}


