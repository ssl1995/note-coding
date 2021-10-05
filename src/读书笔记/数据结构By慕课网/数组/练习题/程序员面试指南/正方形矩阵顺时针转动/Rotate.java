package 读书笔记.数据结构By慕课网.数组.练习题.程序员面试指南.正方形矩阵顺时针转动;


public class Rotate {
    public void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }
    /*
        草稿纸写出四个角的坐标，依次加减i
     */
    public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        // 每次调整的组数:比如0-4=3，需要3组
        int times = dC - tC;
        int temp = 0;
        for (int i = 0; i != times; i++) {
            temp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = temp;
        }
    }
}
