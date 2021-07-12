package 牛客算法课.基础班提升.课12_暴力递归到动态规划;

public class HorseJump {

    public static int ways1(int x, int y, int step) {
        return process(x, y, step);
    }

    public static int process(int x, int y, int step) {
        // 越界的baseCase
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        // 不能动的baseCase:马必须在(0,0)位置跳0步的这一种方法
        if (step == 0) {
            return (x == 0 && y == 0) ? 1 : 0;
        }
        // (x,y)有8个位置到达
        return process(x - 1, y + 2, step - 1)
                + process(x + 1, y + 2, step - 1)
                + process(x + 2, y + 1, step - 1)
                + process(x + 2, y - 1, step - 1)
                + process(x + 1, y - 2, step - 1)
                + process(x - 1, y - 2, step - 1)
                + process(x - 2, y - 1, step - 1)
                + process(x - 2, y + 1, step - 1);
    }

    public static int dpWays(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9 || step < 0) {
            return 0;
        }
        int[][][] dp = new int[9][10][step + 1];
        // baseCase:从（0，0）到0层只有一种方法
        dp[0][0][0] = 1;
        for (int h = 1; h <= step; h++) {// 层:从第一层开始
            for (int r = 0; r < 9; r++) {// x
                for (int c = 0; c < 10; c++) {// y
                    dp[r][c][h] += getValue(dp, r - 1, c + 2, h - 1);
                    dp[r][c][h] += getValue(dp, r + 1, c + 2, h - 1);
                    dp[r][c][h] += getValue(dp, r + 2, c + 1, h - 1);
                    dp[r][c][h] += getValue(dp, r + 2, c - 1, h - 1);
                    dp[r][c][h] += getValue(dp, r + 1, c - 2, h - 1);
                    dp[r][c][h] += getValue(dp, r - 1, c - 2, h - 1);
                    dp[r][c][h] += getValue(dp, r - 2, c - 1, h - 1);
                    dp[r][c][h] += getValue(dp, r - 2, c + 1, h - 1);
                }
            }
        }
        return dp[x][y][step];
    }

    // getValue保证不越界：返回当前三维数组的值
    public static int getValue(int[][][] dp, int row, int col, int step) {
        if (row < 0 || row > 8 || col < 0 || col > 9) {
            return 0;
        }
        return dp[row][col][step];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(ways1(x, y, step));
        System.out.println(dpWays(x, y, step));
    }
}
