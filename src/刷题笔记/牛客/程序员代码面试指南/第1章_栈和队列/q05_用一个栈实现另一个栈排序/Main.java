package 刷题笔记.牛客.程序员代码面试指南.第1章_栈和队列.q05_用一个栈实现另一个栈排序;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/1/9 9:52 PM
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            stack.push(num);
        }
        scanner.close();
        stackSortByStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * 将一个栈实现从栈顶到栈底，元素从大到小排序
     * 只能申请一个辅助栈，其余数据结构不允许
     * stack：[5,8,4,3,6] ->[8,6,5,4,3]
     */
    public static void stackSortByStack(LinkedList<Integer> stack) {
        LinkedList<Integer> help = new LinkedList<>();
        // help栈：从小到大
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            while (!help.isEmpty() && pop > help.peek()) {
                stack.push(help.pop());
            }
            help.push(pop);
        }
        // stack栈：从大到小
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }

    }


}
