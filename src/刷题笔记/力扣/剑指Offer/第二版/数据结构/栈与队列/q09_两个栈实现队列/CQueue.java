package 刷题笔记.力扣.剑指Offer.第二版.数据结构.栈与队列.q09_两个栈实现队列;

import java.util.LinkedList;

public class CQueue {

    private final LinkedList<Integer> stack1;
    private final LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /**
     * 队列尾部添加元素
     */
    public void appendTail(int value) {
        // 往队列中添加元素，只用往栈1中添加即可
        stack1.push(value);
    }

    /**
     * 队列头部删除元素
     */
    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        // 队列出队，栈2为空就要往里面倒入元素保证先进先出
        pushToStack2();
        // 返回栈2的栈顶元素
        return stack2.pop();
    }

    private void pushToStack2() {
        while (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
