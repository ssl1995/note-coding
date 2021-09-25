package 慕课网数据结构.栈.练习题.力扣.力扣232_栈实现队列;

import java.util.Stack;


public class Solution1 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    // front指向出栈元素
    private int front;

    public Solution1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /*
     push:
     1.如果s1空，就让front指向x
     2.将s1全部元素压入s2
     3.s2压入x
     4.最后s2全部元素压入s1
     */
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /*
      pop：
      1.先出栈
      2.再移动front指向s1栈顶
     */
    public int pop() {
        int res = s1.pop();
        if (!s1.isEmpty()) {
            front = s1.peek();
        }
        return res;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
