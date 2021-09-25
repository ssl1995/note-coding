package 慕课网数据结构.数组.练习题.程序员面试指南.之字打印矩阵;

public class PrintMatrixZigZag {

    public void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            // 先打印，再移动指针
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            // tR遍历的第一行末尾前，都不变;否者+1
            tR = (tC == endC) ? tR + 1 : tR;
            // tC没遍历到末尾，都+1;否者+1
            tC = (tC == endC) ? tC : tC + 1;
            dR = (dR == endR) ? dR : dR + 1;
            dC = (dR == endR) ? dC + 1 : dC;
            // 标志位判反
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean fromUp) {
        if (fromUp) {// 从上到下
            while (tR != dR + 1) {
                System.out.println(m[tR++][tC--] + " ");
            }
        } else {// 从下到上
            while (dR != tR - 1) {//
                System.out.println(m[dR--][dC++] + " ");
            }

        }
    }
}
