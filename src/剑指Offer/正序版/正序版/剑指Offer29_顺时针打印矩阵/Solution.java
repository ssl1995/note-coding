package 剑指Offer.正序版.正序版.剑指Offer29_顺时针打印矩阵;

public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        // 输入空列，返回空数组
        if (matrix.length == 0) {
            return new int[0];
        }
        // 初始化左上角、右下角坐标
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        // 结果二维数组大小=原始数组大小
        int[] res = new int[matrix.length * matrix[0].length];
        // 数组遍历坐标
        int index = 0;
        while (tR <= dR && tC <= dC) {
            index = spiralMatrix(matrix, index, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    /**
     * 顺时针赋值二维数组到res中
     *
     * @param index 当前res赋值下标
     * @return 下一个res赋值下标
     */
    private int spiralMatrix(int[][] matrix, int index, int[] res, int tR, int tC, int dR, int dC) {
        if (tR == dR) {// 子矩阵只有一行,就复制列
            for (int i = tC; i <= dC; i++) {
                res[index++] = matrix[tR][i];
            }
        } else if (tC == dC) {// 子矩阵只有一列,就复制行
            for (int i = tR; i <= dR; i++) {
                res[index++] = matrix[i][tC];
            }
        } else {// 一般情况
            // 实现螺旋式顺时针打印
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                res[index++] = matrix[tR][curC++];
            }
            while (curR != dR) {
                res[index++] = matrix[curR++][dC];
            }
            while (curC != tC) {
                res[index++] = matrix[dR][curC--];
            }
            while (curR != tR) {
                res[index++] = matrix[curR--][tC];
            }
        }
        return index;
    }
}
