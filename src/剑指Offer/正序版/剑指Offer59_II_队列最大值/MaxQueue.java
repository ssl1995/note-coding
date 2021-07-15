package 剑指Offer.正序版.剑指Offer59_II_队列最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    // 普通队列:正常的push、pop
    private Queue<Integer> queue;
    // 双端队列:队头保证是最大值
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }


    public void push_back(int value) {
        // 待加元素>双端队列队尾元素,双端队列队尾就一直出队
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int value = queue.poll();
        // 待出队元素,和最大值相同,双端队列队头出队
        if (value == max_value()) {
            deque.pollFirst();
        }
        return value;
    }

    public int max_value() {
        if (deque.isEmpty()) {
            // 条件规定:max栈为空,返回-1
            return -1;
        }
        return deque.peekFirst();
    }

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(4);
        System.out.println(queue.peekFirst());// 1
        System.out.println(queue.peekLast());// 4
    }
}
