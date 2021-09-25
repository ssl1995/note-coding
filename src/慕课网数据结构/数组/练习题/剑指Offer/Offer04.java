package 慕课网数据结构.数组.练习题.剑指Offer;

/**
 * @Author ssl
 * @Date 2020/12/4 20:17
 * @Description 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 标志位从矩阵左下角(matrix.length-1,0)开始
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;

    }
}
