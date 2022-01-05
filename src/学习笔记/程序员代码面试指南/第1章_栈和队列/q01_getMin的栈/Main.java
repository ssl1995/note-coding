package 学习笔记.程序员代码面试指南.第1章_栈和队列.q01_getMin的栈;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/1/5 11:44 PM
 * @description
 */
public class Main {


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        for (int i = 0; i < first; i++) {
            String op = scanner.next();
            if ("push".equals(op)) {
                int num = scanner.nextInt();
                myStack.push(num);
            } else if ("pop".equals(op)) {
                myStack.pop();
            } else if ("getMin".equals(op)) {
                System.out.println(myStack.getMin());
            }
        }
        scanner.close();
    }


}

class MyStack<T extends Comparable<T>> {
    private LinkedList<T> stack1;
    private LinkedList<T> stack2;

    public MyStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(T num) {
        if (stack2.isEmpty() || num.compareTo(getMin()) <= 0) {
            stack2.push(num);
        } else if (num.compareTo(getMin()) > 0) {
            stack2.push(getMin());
        }
        stack1.push(num);
    }

    public T pop() {
        if (stack2.isEmpty() || stack1.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        stack2.pop();
        return stack1.pop();
    }


    public T getMin() {
        if (stack2.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack2.peek();
    }

}

