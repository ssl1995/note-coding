package 刷题笔记.牛客.程序员代码面试指南.第1章_栈和队列.q01_getMin的栈;

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
        // 示例中的6，作为遍历次数
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String op = scanner.next();
            if ("push".equals(op)) {
                int num = scanner.nextInt();
                myStack.push(num);
            } else if ("pop".equals(op)) {
                myStack.pop();
            } else if ("getMin".equals(op)) {
                // 只有遇到getMin才输出
                System.out.println(myStack.getMin());
            }
        }
        scanner.close();
    }


}

class MyStack<T extends Comparable<T>> {
    private LinkedList<T> dataStack;
    private LinkedList<T> minStack;

    public MyStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(T num) {
        // data和min两个栈同步压入数据
        if (minStack.isEmpty() || num.compareTo(getMin()) < 0) {
            minStack.push(num);
        } else {
            minStack.push(getMin());
        }
        dataStack.push(num);
    }

    public T pop() {
        if (minStack.isEmpty() || dataStack.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        minStack.pop();
        return dataStack.pop();
    }


    public T getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return minStack.peek();
    }

}

