package 程序员代码面试指南.第1章_栈和队列.两个栈组成的队列.力扣;

import java.util.LinkedList;
import java.util.Queue;

// 力扣225:用队列实现栈
class MyStack1 {
    // 用2个队列实现栈
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // 1.q2先入元素，辅助队列中暂存队列头的元素
        queue2.offer(x);
        // 2.q1中的元素全部入q2
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 3.交换2个栈
        Queue<Integer> temp;
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }


    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}