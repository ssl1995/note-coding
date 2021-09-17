package 牛客.算法课.中级班.课5.Q01_斐波那契线代套路;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // 根据递推公式算出来的系数矩阵
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        // f(n)=res的第一列相加
        return res[0][0] + res[1][0];
    }

    // 系数矩阵的p次方
    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;// 单位矩阵1的概念
        }
        int[][] temp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {// p次方该二进制位为1，就加上temp
                res = muliMatrix(res, temp);
            }
            temp = muliMatrix(temp, temp);
        }
        return res;
    }

    // 两个矩阵相乘
    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
