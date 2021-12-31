package 读书笔记.剑指Offer.专项突击版.第6章_栈.q39_直方图最大矩形;

/**
 * @author SongShengLin
 * @date 2021/10/7 9:47 上午
 * @description
 */
public class Solution {
    // 暴力法:时间超时
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        // 依次找出最矮矩形，和其后的矩形面积比较找最小
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
