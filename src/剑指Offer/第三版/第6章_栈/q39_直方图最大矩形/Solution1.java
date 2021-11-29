package 剑指Offer.第三版.第6章_栈.q39_直方图最大矩形;

/**
 * @author SongShengLin
 * @date 2021/10/7 9:47 上午
 * @description
 */
public class Solution1 {
    // 分治法:还是会超时
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length);
    }

    /**
     * 递归：找出heights以start作为起点，end作为终点的最大矩阵面积
     */
    private int helper(int[] heights, int start, int end) {
        // 递归结束条件1:左右下标相同，面积为0
        if (start == end) {
            return 0;
        }
        // 递归结束条件2：左指针+1=右指针，面试为1*这个矩形面试
        if (start + 1 == end) {
            return heights[start];
        }
        // 在start右边找最小矩形坐标
        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        // 递归分治
        int area = (end - start) * heights[minIndex];
        int left = helper(heights, start, minIndex);
        int right = helper(heights, minIndex + 1, end);
        // 返回三者最大，即为矩阵中面积最大值
        return Math.max(area, Math.max(left, right));
    }
}
