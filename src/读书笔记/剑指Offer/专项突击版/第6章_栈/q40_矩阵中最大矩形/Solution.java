package 读书笔记.剑指Offer.专项突击版.第6章_栈.q40_矩阵中最大矩形;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/7 11:07 上午
 * @description
 */
public class Solution {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0 || matrix[0].length() == 0) {
            return 0;
        }
        // 将一维字符串数组转换为二维字符数组
        char[][] css = new char[matrix.length][matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                css[i][j] = matrix[i].charAt(j);
            }
        }
        // 每一行都当做一个直方图
        int[] heights = new int[css[0].length];
        int maxArea = 0;
        for (char[] cs : css) {
            for (int i = 0; i < cs.length; i++) {
                // 遇见'0',重置高度为0
                if (cs[i] == '0') {
                    heights[i] = 0;
                } else {// 遇到非'0',高度+1
                    heights[i]++;
                }
            }
            // 计算每一行的直方图最大面积
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    // 单调栈
    private int largestRectangleArea(int[] heights) {
        // 栈：存下标，保证从栈底到栈顶单调递增
        // 由于算矩形面积需要宽，所以栈中存下标
        LinkedList<Integer> stack = new LinkedList<>();
        // 数组最左边前一个元素没有对应下标，栈底让其默认存一个下标-1便于计算宽
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // 出栈：入栈元素值<=当前栈顶下标对应的元素值
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 计算高度，用pop
                int height = heights[stack.pop()];
                // 计算宽度，用peek；自己画图，宽度i-peek-1
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        // 如果栈中还有非-1的下标，全部出栈，计算面积
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            // 数组末尾元素的下一个元素下标不存在，用heights.length代替计算宽度
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}
