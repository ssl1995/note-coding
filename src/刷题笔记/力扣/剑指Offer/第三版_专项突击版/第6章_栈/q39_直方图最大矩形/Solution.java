package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第6章_栈.q39_直方图最大矩形;

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
            // min表示从i位置往后，能包含当前柱子的最小柱子高度
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
