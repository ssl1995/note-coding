package interview.wangyi.Q3_最小费用;

public class Solution {
    private int res = 0;

    public int minSailCost(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        process(input, 0, 0, m, n);
        return res < 0 ? -1 : res;

    }

    private int process(int[][] input, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || input[i][j] == 2) {
            return -1;
        }
        if (i == m - 1 && j == n - 1) {
            return res;
        }
        if (input[i][j] == 0) {
            return 2;
        }
        if (input[i][j] == 1) {
            return 1;
        }
        res += process(input, i + 1, j, m, n);
        res += process(input, i, j + 1, m, n);
        return res;
    }
}
