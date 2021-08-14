package interview.bole;


public class NQueens {

    public int queens(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    public int process(int i, int[] record, int n) {
        // base case:如果i来到终止行n,潜台词就是前面i-1行保证了N皇后的条件,这就是一种摆法
        if (i == n) {
            return 1;
        }
        int res = 0;
        // i=行数，j=列数
        for (int j = 0; j < n; j++) {
            // 当前i行的皇后放在j列，会不会出现问题
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    // 判断第i行第j列能放皇后
    public boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.queens(4));
    }


}
