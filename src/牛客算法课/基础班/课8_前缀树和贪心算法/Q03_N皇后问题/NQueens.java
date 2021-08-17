package 牛客算法课.基础班.课8_前缀树和贪心算法.Q03_N皇后问题;


public class NQueens {
    // N皇后问题：N个数，在N*N的数组中，每个数都不共行、列和斜线的摆法
    // 法1：暴力递归
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        // 下标：行数;值：该行有哪列被使用过
        int[] record = new int[n];
        return dfs(record, 0, n);
    }

    public static int dfs(int[] record, int i, int n) {
        // base case:如果i来到终止行n,说明前面的摆法都行，返回1
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {// i=行数，j=列数
            if (isValid(record, i, j)) {// 从i行开始的所有列判断皇后是否能放入
                record[i] = j;
                res += dfs(record, i + 1, n);
            }
        }
        return res;
    }


    // 判断第i行第j列能放皇后
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            // 共行: 不用检查i后的共行问题，因为是按行逐渐放皇后，不会出现i行后的共行问题
            // 共列: 从0到i遍历record，如果j==record[k]说明i之前有皇后放在了该列上
            // 共斜线: 等腰三角形直角边相同：Math.abs(record[k] - j) == Math.abs(i - k))
            if (j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }


    // 法2：位运算优化法，但是限制是不要超过32位（n是int类型）
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        // limit是2^n-1：二进制为1的n位数
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    public static int process2(int upperLim, int colLim, int leftDiaLim,
                               int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(upperLim, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 14;

        long start = System.currentTimeMillis();
        System.out.println(num2(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(num1(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

    }


}
