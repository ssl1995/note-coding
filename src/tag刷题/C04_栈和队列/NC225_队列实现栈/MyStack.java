package tag刷题.C04_栈和队列.NC225_队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 原先队列是右进左出的
        int size = queue.size();
        // 先加一个元素后，让前面的元素重新右进一次，保持队列最前面是最后入的元素
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
