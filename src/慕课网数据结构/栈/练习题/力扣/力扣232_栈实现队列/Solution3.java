package 慕课网数据结构.栈.练习题.力扣.力扣232_栈实现队列;

import java.util.Stack;

public class Solution3 {
    // 左神的解法，统一使用pushToPop方法
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public Solution3() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    private void pushToPop() {
        while (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void push(int x) {
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
