package 刷题笔记.力扣.LC225_队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack1 {
    // 用1个队列，模拟1个栈
    private Queue<Integer> queue;

    public MyStack1() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 保证后进的元素，维持在队列头部，便于出去
        int size = queue.size();
        queue.add(x);
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
