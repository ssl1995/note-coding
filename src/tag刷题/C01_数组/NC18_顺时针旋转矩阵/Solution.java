package tag刷题.C01_数组.NC18_顺时针旋转矩阵;

import java.util.Arrays;

public class Solution {
    public int[][] rotateMatrix(int[][] mat, int n) {
        int tR = 0, tC = 0;
        int dR = n - 1, dC = n - 1;
        while (tR < dR) {// 于的时候不是矩阵，只是一条线了，不能再旋转
            rotate(mat, tR++, tC++, dR--, dC--);
        }
        return mat;
    }

    private void rotate(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dR - tR;// 重新赋值次数为列差or行差
        int temp;
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
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = 3;
        int[][] res = solution.rotateMatrix(matrix, n);
        System.out.println(Arrays.deepToString(res));
    }
}
