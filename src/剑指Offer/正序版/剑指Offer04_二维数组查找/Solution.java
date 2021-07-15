package 剑指Offer.正序版.剑指Offer04_二维数组查找;

public class Solution {

    // 二分搜索法:从矩阵左下角开始
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 最左下角坐标:[matrix.length-1][0]
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col <= matrix[0].length - 1) {
            if (matrix[row][col] < target) {
                row--;
            } else if (matrix[row][col] > target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
