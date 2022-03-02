package 刷题笔记.力扣.热门100.LC240_搜索二维矩阵II;

/**
 * @author SongShengLin
 * @date 2021/11/30 10:28 下午
 * @description
 */
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
