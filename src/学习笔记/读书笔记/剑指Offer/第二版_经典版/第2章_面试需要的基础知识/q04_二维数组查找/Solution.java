package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第2章_面试需要的基础知识.q04_二维数组查找;

public class Solution {


    /**
     * 二维数组中的查找，元素值从上到小、从左到右递增
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 最左下角坐标:[matrix.length-1][0]
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
