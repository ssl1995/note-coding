package 读书笔记.剑指Offer.第二版.剑指Offer04_二维数组查找;

public class Solution {

    // 二分搜索法:从矩阵左下角开始
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
