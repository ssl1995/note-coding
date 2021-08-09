package 牛客算法课.中级班.课3.Q02_Z字打印矩阵;

public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        // 初始化:A(tR，tC),B(dR,dC)从原点出发
        // A从右往左到头，才往下
        // B从上往下到头，才往右
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        // true:从下往上打印;false:从上往下打印
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {// true:从下往上打印
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {// false:从上往下打印
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }

}
