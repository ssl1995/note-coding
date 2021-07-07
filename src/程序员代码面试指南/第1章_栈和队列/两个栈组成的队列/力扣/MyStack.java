package 程序员代码面试指南.第1章_栈和队列.两个栈组成的队列.力扣;

import java.util.LinkedList;
import java.util.Queue;

// 力扣225:用队列实现栈
class MyStack {
    // 用一个队列实现栈
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 1.先记录模拟栈原数据个数
        int n = queue.size();
        // 2.新数据进栈
        queue.offer(x);
        // 3.之前个数的元素重新入栈
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}