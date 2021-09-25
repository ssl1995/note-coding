package 慕课网数据结构.栈.练习题.程序员面试指南.设计一个GetMin栈;


import java.util.Stack;

public class GetMinStack {

    private Stack<Integer> data;
    private Stack<Integer> min;

    public GetMinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    // push1:>最小值就不压入，不保持同步
    public void push1(int newNum) {

        if (min.isEmpty()) {
            min.push(newNum);
        } else if (newNum <= getMin()) {
            min.push(newNum);
        }
        data.push(newNum);
    }

    // pop1:数据栈和最小值相同，最小值也出栈
    public int pop1() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Your stack is empty");
        }
        // 出栈数和最小值，相同，min栈也出栈
        int value = data.pop();
        if (value == getMin()) {
            min.pop();
        }
        return value;
    }

    // push2:最小值重复入最小值，保持同步
    public void push2(int newNum) {
        if (min.isEmpty()) {
            min.push(newNum);
        } else if (newNum < getMin()) {
            min.push(newNum);
        } else {
            int newMin = min.peek();
            min.push(newMin);
        }
        data.push(newNum);
    }
    // pop2:两个栈都出栈
    public int pop2() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Your stack is empty");
        }
        min.pop();
        return data.pop();
    }


    public int getMin() {
        if (min.isEmpty()) {
            throw new IllegalArgumentException("Your stack is empty");
        }
        return min.peek();
    }
}
