package 刷题笔记.力扣.热门100.LC84_柱状图中最大矩形;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2022/1/29 3:29 PM
 * @description
 */
public class Solution {
    /**
     * 柱状图中最大矩形
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     * 解释：最大的矩形为图中红色区域，面积为 10
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // 单调栈：从栈底到栈顶数组元素值递增
        LinkedList<Integer> stack = new LinkedList<>();
        // 预存一个宽度为-1(不存在)的值
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 面积  = 高*宽(宽是难点，多悟悟)
                maxArea = Math.max(heights[stack.pop()] * (i - 1 - stack.peek()), maxArea);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(heights[stack.pop()] * (heights.length - 1 - stack.peek()), maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
