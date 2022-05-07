package 学习笔记.读书笔记.程序员代码面试指南.第1章_栈和队列.q02_两个栈组成的队列;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/1/6 12:02 AM
 * @description
 */
public class Main {

    public static void main(String[] args) {
        TwoStacksQueue<Integer> twoStacksQueue = new TwoStacksQueue<>();
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        for (int i = 0; i < first; i++) {
            String op = scanner.next();
            if ("add".equals(op)) {
                int num = scanner.nextInt();
                twoStacksQueue.add(num);
            } else if ("peek".equals(op)) {
                System.out.println(twoStacksQueue.peek());
            } else if ("poll".equals(op)) {
                // 根据输入示例，poll不输出
                twoStacksQueue.poll();
            }
        }
        scanner.close();
    }

}

class TwoStacksQueue<T> {
    private LinkedList<T> stack1;
    private LinkedList<T> stack2;

    public TwoStacksQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void add(T num) {
        stack1.push(num);
    }

    public T poll() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        pushToPop();
        return stack2.pop();
    }

    public T peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        pushToPop();
        return stack2.peek();
    }

    private void pushToPop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
