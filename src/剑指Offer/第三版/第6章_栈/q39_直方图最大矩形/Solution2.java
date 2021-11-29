package 剑指Offer.第三版.第6章_栈.q39_直方图最大矩形;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/7 9:47 上午
 * @description
 */
public class Solution2 {
    // 单调栈
    public int largestRectangleArea(int[] heights) {
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
