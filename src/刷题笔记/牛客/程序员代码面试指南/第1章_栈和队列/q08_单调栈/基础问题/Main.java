package 刷题笔记.牛客.程序员代码面试指南.第1章_栈和队列.q08_单调栈.基础问题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/3/13 5:41 PM
 * @description
 */
public class Main {


    /**
     * 题目：获取i位置左右两边最小值下标
     * 输入：
     * 7
     * 3 4 1 5 6 2 7
     * 输出：
     * -1 2
     * 0 2
     * -1 -1
     * 2 5
     * 3 5
     * 2 -1
     * 5 -1
     */
    private static int[][] getNearLessNoRepeat(int[] arr) {
        if (arr == null) {
            return new int[][]{};
        }
        // nums = {3, 4, 1, 5, 6, 2, 7}
        int[][] res = new int[arr.length][2];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            // 单调栈：保证栈底到栈顶严格递增
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                Integer pop = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                res[pop][0] = left;
                res[pop][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            res[pop][0] = left;
            res[pop][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (sc.hasNextInt()) {
            arr[i++] = sc.nextInt();
        }
        sc.close();
//        int[] arr = {3, 4, 1, 5, 6, 2, 7};

        int[][] res = getNearLessNoRepeat(arr);
        printArr(res);
    }

    private static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
