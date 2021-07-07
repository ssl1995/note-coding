package 程序员代码面试指南.第1章_栈和队列.单调栈结构;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class getNearIndex1 {

    // 给定一个重复的数组，找到左右最靠近小于它的下标
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // 大于
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popList = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popValue : popList) {
                    res[popValue][0] = leftLessIndex;
                    res[popValue][1] = i;
                }
            }
            // 等于
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {// 小于
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
            }
        }
        // 栈不空，就遍历出栈
        while (!stack.isEmpty()) {
            List<Integer> popList = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.size() - 1);
            for (Integer popValue : popList) {
                res[popValue][0] = leftLessIndex;
                res[popValue][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[][] res = getNearLessNoRepeat(arr);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

}
