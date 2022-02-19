package 学习笔记.算法面试40讲.C35_求平方根.LC69_平方根;

/**
 * @author SongShengLin
 * @date 2022/2/19 4:56 PM
 * @description
 */
public class Solution {
    /**
     * 求x平方根
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1, right = x;
        int res = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid + 1;
                // 左边界移动，res等于mid
                res = mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return res;
    }
}
