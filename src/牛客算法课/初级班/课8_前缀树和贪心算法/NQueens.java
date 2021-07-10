package 牛客算法课.初级班.课8_前缀树和贪心算法;


public class NQueens {
    // N皇后问题：N个数，在N*N的数组中，每个数都不共行、列和斜线
    // 学完num1方法，LC51_NQueens怎么改写成num1
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        // 不使用list。
        // 用record[i]=value表示第i行的皇后，放在value列
        int[] record = new int[n];
        return process1(0, record, n);
    }

    /**
     * i 目前来到了第几行
     * record[0-i-1]表示之前的行，已经放了皇后的位置
     * n 代表整体一共有多少行
     * 返回值：摆完目前所有的皇后，合理的摆法数量
     */
    public static int process1(int i, int[] record, int n) {
        // 递归结束条件：如果i来到终止行，潜台词就是前面i-1行保证了N皇后的条件，所以最后一行返回1
        if (i == n) {
            return 1;
        }
        int res = 0;
        // i=行数，j=列数
        for (int j = 0; j < n; j++) {
            // 当前i行的皇后放在j列，会不会出现问题
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            // Q1: 不用检查i后的共行问题，因为是按行逐渐放皇后，不会出现i行后的共行问题
            // Q2: 检查共列问题，j == record[k]
            // Q3: 检查共斜线问题，等腰三角形直角边相同：Math.abs(record[k] - j) == Math.abs(i - k))
            if (j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    // 位运算优化法：但是限制是不要超过32位（n是int类型）
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
