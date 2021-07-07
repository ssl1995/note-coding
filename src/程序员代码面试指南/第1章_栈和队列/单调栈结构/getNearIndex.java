package 程序员代码面试指南.第1章_栈和队列.单调栈结构;

import java.util.Stack;

public class getNearIndex {

    // 给定一个不重复的数组，找到左右最靠近小于它的下标
    public static int[][] getNearLessNoRepeat(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            // 遍历辅助栈，peek()>arr[i]就要出栈
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            // 遍历辅助栈时，因为无数再入，所以值为-1
            res[popIndex][1] = -1;
        }
        return res;
    }
}
