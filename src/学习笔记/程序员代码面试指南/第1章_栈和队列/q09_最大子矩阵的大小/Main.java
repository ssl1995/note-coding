package 学习笔记.程序员代码面试指南.第1章_栈和队列.q09_最大子矩阵的大小;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2022/3/15 9:12 AM
 * @description
 */
public class Main {

    /**
     * 输入：
     * 1 4
     * 1 1 1 0
     * 输出：
     * 3
     * 说明：
     * 最大的矩形区域有3个1，所以返回3
     */
    private static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0) {
            return 0;
        }
        int m = map.length;
        int n = map[0].length;
        int[] height = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }

        return maxArea;
    }

    private static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int maxArea = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                // j位置往左括最大能到k+1；j位置往右扩至少能到i-1
                // j位置能扩出来的最大矩阵面积：高=height[i],长=i-1-(k+1)+1=i-k-1
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            // 栈还非空，最右边位置取数组长度，表示最右边数极值小，所有栈中都要清空
            int curArea = (n - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }

    public static void main(String[] args) throws IOException {
//        int[][] map = {{1, 0, 1, 1}, {1, 1, 1, 1,}, {1, 1, 1, 0}};
//        System.out.println(maxRecSize(map));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            numbers = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        System.out.println(maxRecSize(map));

    }
}
