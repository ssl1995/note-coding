package 力扣.剑指Offer.第二版.剑指Offer30_包含min函数的栈;


import java.util.Stack;

public class JZ20 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // s1和s2同步压入
    public void push(int node) {
        // s2压入node规则：s2一开始为空||新的值更小
        if (stack2.isEmpty() || node <= min()) {
            stack2.push(node);
        } else {// 新的值更大，s2压入原先的最小值
            stack2.push(min());
        }
        stack1.push(node);
    }

    public void pop() {
        if (stack1.isEmpty()) {
            return;
        }
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    public int min() {
        if (stack2.isEmpty()) {
            return -1;
        }
        // 最小值也是peek，不是pop
        return stack2.peek();
    }
}
