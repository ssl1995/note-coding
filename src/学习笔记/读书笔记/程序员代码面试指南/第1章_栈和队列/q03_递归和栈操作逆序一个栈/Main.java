package 学习笔记.读书笔记.程序员代码面试指南.第1章_栈和队列.q03_递归和栈操作逆序一个栈;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author SongShengLin
 * @date 2022/1/6 11:57 PM
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int cap = scanner.nextInt();
        for (int i = 0; i < cap; i++) {
            int num = scanner.nextInt();
            stack.push(num);
        }
        scanner.close();
        reverseStack(stack);
        printStack(stack, stack.size());
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int num = getAndRemoveLast(stack);
        reverseStack(stack);
        stack.push(num);
    }

    private static int getAndRemoveLast(Stack<Integer> stack) {
        int pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {
            int last = getAndRemoveLast(stack);
            stack.push(pop);
            return last;
        }
    }

    private static void printStack(Stack<Integer> stack, int n) {
        int i = 0;
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            i++;
            // 取消末尾多打印的空格
            if (i < n) {
                System.out.print(" ");
            }
        }
    }


}

