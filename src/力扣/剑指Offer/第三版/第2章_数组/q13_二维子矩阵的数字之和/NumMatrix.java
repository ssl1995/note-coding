package 力扣.剑指Offer.第三版.第2章_数组.q13_二维子矩阵的数字之和;

public class NumMatrix {

    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // 防止r-1,c-1在0位置越界，sums数组初始化多1行1列
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                // rowSum算原数组每一行的和
                rowSum += matrix[i][j];
                // sums = 上一行此列的sums + 本行目前元素值的和
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 原：[r2][c2]-[r1-1][c2]-[r2][c1-1]+[r1-1][c1-1]，多减了一个左上角的区域，最后要加上来
        // 转换成加了一行一列的sums，需要全部坐+1
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };
        /*
            sums = {
                0，0，0，0，0，0
                0，3，3，4，8，10
                0，8，14，18，24，27
                0，9，17，21，28，36
                0，13，22，26，34，49
                0，14，23，30，38，58
            }
         */
        NumMatrix numMatrix = new NumMatrix(matrix);
        // 计算左上角(3,2),右下角(5,4)矩阵元素的和
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        // 计算左上角(2,2),右下角(3,3)矩阵元素的和
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        // 计算左上角(2,3),右下角(3,5)矩阵元素的和
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
