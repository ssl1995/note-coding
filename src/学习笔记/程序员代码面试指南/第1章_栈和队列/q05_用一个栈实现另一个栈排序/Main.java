package 学习笔记.程序员代码面试指南.第1章_栈和队列.q05_用一个栈实现另一个栈排序;

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
     */
    public static void stackSortByStack(LinkedList<Integer> stack) {
        LinkedList<Integer> help = new LinkedList<>();
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            // help实现从栈顶到栈底，从小到大排序
            while (!help.isEmpty() && pop > help.peek()) {
                stack.push(help.pop());
            }
            help.push(pop);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }

    }


}
