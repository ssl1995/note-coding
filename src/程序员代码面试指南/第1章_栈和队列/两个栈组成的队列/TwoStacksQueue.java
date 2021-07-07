package 程序员代码面试指南.第1章_栈和队列.两个栈组成的队列;

import java.util.Stack;


public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    // 栈实现队列只用学习这一个方法
    // 定义一个压栈函数:如果pop栈为空，就一次性把push栈中元数入pop栈
    private void pushToPop() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    // 添加之后，保证一个压栈操作
    public void add(int pushInt) {
        stackPush.push(pushInt);
        pushToPop();
    }

    // 出栈之前，保证一个压栈操作
    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    // 出栈之前，保证一个压栈操作
    public int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

    // 判空之前，保证一个压栈操作
    public boolean empty() {
        pushToPop();
        return stackPush.isEmpty();
    }
}
