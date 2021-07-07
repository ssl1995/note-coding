package 程序员代码面试指南.第1章_栈和队列.两个栈组成的队列.力扣;

import java.util.Stack;

// 力扣232
class MyQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public MyQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    // 栈实现队列方法1：摊还时间复杂度
    private void pushToPop() {
        while (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void push(int x) {
        pushToPop();
        stackPush.push(x);
        pushToPop();
    }


    public int pop() {
        if (empty()) {
            throw new IllegalArgumentException("Stack is Empty");
        }
        pushToPop();
        return stackPop.pop();
    }


    public int peek() {
        if (empty()) {
            throw new IllegalArgumentException("Stack is Empty");
        }
        pushToPop();
        return stackPop.peek();
    }


    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}


