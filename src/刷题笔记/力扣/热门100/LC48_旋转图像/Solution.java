package 刷题笔记.力扣.热门100.LC48_旋转图像;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/1/24 9:01 AM
 * @description
 */
public class Solution {
    /**
     * 旋转图像
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dR - tR;
        int temp = 0;
        for (int i = 0; i < times; i++) {
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
