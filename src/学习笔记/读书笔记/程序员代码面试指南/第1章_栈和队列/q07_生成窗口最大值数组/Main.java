package 学习笔记.读书笔记.程序员代码面试指南.第1章_栈和队列.q07_生成窗口最大值数组;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/3/13 12:42 AM
 * @description
 */
public class Main {

    /**
     * q07_生成窗口最大值数组
     * 输入：
     * 8 3
     * 4 3 5 4 3 3 6 7
     * 输出：
     * 5 5 5 4 6 7
     */
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;

        // 双端队列队头，存w区间内最大值
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);

            // 队头过期：超过i-w的长度
            if (queue.peekFirst() == i - w) {
                queue.pollFirst();
            }

            if (i >= w - 1) {
                res[index++] = arr[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();

        int[] arr = new int[n];
        int index = 0;
        while (sc.hasNextInt()) {
            arr[index++] = sc.nextInt();
        }

        Main main = new Main();
        int[] res = main.getMaxWindow(arr, w);


        for (int num : res) {
            System.out.print(num + " ");
        }

    }

}
