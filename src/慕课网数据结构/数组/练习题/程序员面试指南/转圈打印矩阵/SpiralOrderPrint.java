package 慕课网数据结构.数组.练习题.程序员面试指南.转圈打印矩阵;

public class SpiralOrderPrint {


    public void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        // 向中间挤压遍历
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }

    }

    /*
     使用宏观的左上角下标和右下角下标解决
      (tR,tC)
                 (dR,dC)
     */
    public void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {// 行数相同=只有一行
            for (int i = tC; i <= dC; i++) {
                System.out.println(m[tR][i] + "");
            }
        } else if (tC == dC) { // 列数相同=只有一列
            for (int i = tR; i <= dR; i++) {
                System.out.println(m[tC][i] + "");
            }
        } else {// 一般情况
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                System.out.println(m[tR][curC] + "");
                curC++;
            }
            while (curR != dR) {
                System.out.println(m[curR][dC] + "");
                curR++;
            }
            while (curC != tC) {
                System.out.println(m[dR][curC] + "");
                curC--;
            }
            while (curR != tR) {
                System.out.println(m[curR][tC] + "");
                curR--;
            }
        }
    }

}
