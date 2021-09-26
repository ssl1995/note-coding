package 慕课网数据结构.栈.练习题.力扣.力扣225_队列实现栈;

import java.util.LinkedList;
import java.util.Queue;


public class Solution2 {
    // 使用1个队列实现实现栈
    private Queue<Integer> queue;

    public Solution2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 1.未加入元素时，先记录队列长度
        int n = queue.size();
        // 2.队列元素出队再入队，保证交换顺序
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int top() {
        return queue.peek();
    }

    public int pop() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
