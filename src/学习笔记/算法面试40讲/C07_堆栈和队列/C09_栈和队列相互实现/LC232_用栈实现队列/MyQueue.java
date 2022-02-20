package 学习笔记.算法面试40讲.C07_堆栈和队列.C09_栈和队列相互实现.LC232_用栈实现队列;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2022/2/16 8:51 AM
 * @description
 */
public class MyQueue {
    /**
     * 用栈实现队列，一定是使用两个栈：stack1正常压入，stack2维持stack1的栈底到stack2的栈顶
     */
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        // 栈1非空，栈2为空，往栈2压入数据
        if (stack2.isEmpty()) {
            pushStack2();
        }
        return stack2.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        // 栈1非空，栈2为空，往栈2压入数据
        if (stack2.isEmpty()) {
            pushStack2();
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * 摊还时间复杂度
     */
    private void pushStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
