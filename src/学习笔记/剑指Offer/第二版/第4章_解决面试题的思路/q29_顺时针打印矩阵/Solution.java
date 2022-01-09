package 学习笔记.剑指Offer.第二版.第4章_解决面试题的思路.q29_顺时针打印矩阵;


import java.util.Arrays;

public class Solution {
    /**
     * 顺时针打印矩阵
     */
    public int[] spiralOrder(int[][] matrix) {
        // 输入空列，返回空数组
        if (matrix.length == 0) {
            return new int[0];
        }
        // 初始化左上角坐标(tR,tC)=(0,0)、右下角坐标(dR,dC)=()
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        // 遍历结束：(tR,tC)(dR,dC)在矩阵中心相遇
        while (tR <= dR && tC <= dC) {
            index = spiralMatrix(matrix, index, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private int spiralMatrix(int[][] matrix, int index, int[] res, int tR, int tC, int dR, int dC) {
        // 子矩阵只有一行,从左到右复制
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                res[index++] = matrix[tR][i];
            }
            // 子矩阵只有一列,从上到下复制
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                res[index++] = matrix[i][tC];
            }
        } else {// 一般情况,取不到=号
            for (int i = tC; i < dC; i++) {
                res[index++] = matrix[tR][i];
            }
            for (int i = tR; i < dR; i++) {
                res[index++] = matrix[i][dC];
            }
            // 注意：变成>
            for (int i = dC; i > tC; i--) {
                res[index++] = matrix[dR][i];
            }
            for (int i = dR; i > tR; i--) {
                res[index++] = matrix[i][tC];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[] res = solution.spiralOrder(m);
        // 正确：[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
        System.out.println(Arrays.toString(res));
    }
}
