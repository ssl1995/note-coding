package 学习笔记.算法面试40讲.C09_栈和队列相互实现.LC225_队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /**
     * 队列实现栈：可以用一个队列，模拟一个栈
     */
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 保证后进的元素，维持在队列头部，便于出去
        // 所以先记录之前队列的长度
        int size = queue.size();
        queue.add(x);
        // 之前长度内的元素重新进入队列，让x保持在队头
        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
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
