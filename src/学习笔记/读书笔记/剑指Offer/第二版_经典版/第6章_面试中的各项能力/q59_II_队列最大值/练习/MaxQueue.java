package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q59_II_队列最大值.练习;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2022/1/16 10:06 PM
 * @description
 */
public class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && value >= deque.peekLast()) {
            deque.pollLast();
        }
        queue.offer(value);
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer res = queue.poll();
        if (res == max_value()) {
            deque.pollFirst();
        }
        return res;
    }
}
