package 刷题笔记.力扣.热门100.LC85_最大矩形;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2022/1/29 4:25 PM
 * @description
 */
public class Solution {
    /**
     * 最大矩形
     * matrix = [["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]]
     * 输出：6
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // 复用84题逻辑，将二维matrix中的1理解为一维数组中的高度
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (char[] rows : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[j] == '0') {
                    heights[j] = 0;
                } else if (rows[j] == '1') {
                    heights[j]++;
                }
            }
            // 每一行结束就当前行取到的最大矩形面积
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    /**
     * 柱状图中最大矩形
     * 力扣84题
     */
    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalRectangle(matrix));
    }
}


