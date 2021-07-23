package tag刷题.C01_数组.剑指Offer29_顺时针打印矩阵;

import java.util.ArrayList;

public class JZ19 {
    // 牛客:顺时针打印矩阵，与力扣的区别是返回值不一样
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            print(matrix, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private void print(int[][] matrix, ArrayList<Integer> res, int tR, int tC, int dR, int dC) {
        // 只有一行一列时，i可以到端点
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                res.add(matrix[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                res.add(matrix[i][tC]);
            }
        } else {// 一般情况时，i不能到端点
            for (int i = tC; i < dC; i++) {
                res.add(matrix[tR][i]);
            }
            for (int i = tR; i < dR; i++) {
                res.add(matrix[i][dC]);
            }
            for (int i = dC; i > tC; i--) {
                res.add(matrix[dR][i]);
            }
            for (int i = dR; i > tR; i--) {
                res.add(matrix[i][tC]);
            }
        }
    }

    public static void main(String[] args) {
        JZ19 solution1 = new JZ19();
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> res = solution1.printMatrix(m);
        // 正确：[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
        System.out.println(res);
    }
}
