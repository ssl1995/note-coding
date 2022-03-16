package 学习笔记.程序员代码面试指南.第1章_栈和队列.q08_单调栈.进阶问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/3/14 9:33 AM
 * @description
 */
public class Main {

    /**
     * 进阶问题
     * 数组中有重复数据
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
    private static int[][] getNearLess(int[] arr) {
        if (arr == null) {
            return new int[][]{};
        }
        int[][] res = new int[arr.length][2];
        // arr有重复数据，栈中有list
        LinkedList<List<Integer>> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> pop = stack.pop();
                // left取最右边的=最后加入的元素
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer index : pop) {
                    res[index][0] = left;
                    res[index][1] = i;
                }
            }
            // 等于加入list
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            // left取最右边的=最后加入的元素
            int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer i : pop) {
                res[i][0] = left;
                res[i][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(numbers[0]);
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            String[] nums = bufferedReader.readLine().split(" ");
            arr[i] = Integer.parseInt(nums[i]);
        }

        int[][] res = getNearLess(arr);
        printArr(res);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        int i = 0;
//        while (sc.hasNextInt()) {
//            arr[i++] = sc.nextInt();
//        }
//        sc.close();
//
//        getNearLess(arr);

//        printArr(res);
//        int[] arr = {3, 4, 1, 5, 6, 2, 7};
//        int[][] nearLess = getNearLess(arr);
//        System.out.println(Arrays.deepToString(nearLess));
    }

    private static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

}
