package 刷题笔记.牛客.程序员代码面试指南.第1章_栈和队列.q08_单调栈.进阶问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
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
     * 如果数组中有重复数据
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
        // arr={3,1,3,4,3,5,3,2,2}
        int[][] res = new int[arr.length][2];
        // 如果arr有重复数据，单调栈存集合
        Deque<List<Integer>> stack = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // 出栈
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> pop = stack.pop();
                // left取最右边的=最后加入的元素
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer index : pop) {
                    res[index][0] = left;
                    res[index][1] = i;
                }
            }
            // 进栈
            // 如果和栈顶相同，就加入集合
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                // 如果和栈顶不同，就自己是一个集合
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
    }

    private static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

}
