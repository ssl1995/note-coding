package 牛客算法课.基础班提升.课7_动态规划2.Q03_Bob生存概率;

public class BobDie {

    // Q:区域n*m,Bob在(i,j)走k步,还在n*m区域内的概率
    public static String bob1(int N, int M, int i, int j, int K) {
        // 走k步,四个方向的总区域:4^k
        long all = (long) Math.pow(4, K);
        // Bob存活的概率
        long live = process(N, M, i, j, K);
        // 两者的最大公约数
        long gcd = gcd(all, live);
        // 返回生存概率
        return (live / gcd) + "/" + (all / gcd);
    }

    // 获得Bob存活的方法数
    public static long process(int N, int M, int row, int col, int rest) {
        // Bob来到任何一个越界的位置,就希望了
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }
        // 剩余步数为0,bob存活
        if (rest == 0) {
            return 1;
        }
        long live = process(N, M, row - 1, col, rest - 1);// 向上
        live += process(N, M, row + 1, col, rest - 1);// 向下
        live += process(N, M, row, col - 1, rest - 1);// 向左
        live += process(N, M, row, col + 1, rest - 1);// 向右
        return live;
    }

    // 获得某两个数的最大公约数
    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    // 递归改成动态规划
    public static String bob2(int N, int M, int i, int j, int K) {
        int[][][] dp = new int[N + 2][M + 2][K + 1];
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                dp[row][col][0] = 1;
            }
        }
        for (int rest = 1; rest <= K; rest++) {
            for (int row = 1; row <= N; row++) {
                for (int col = 1; col <= M; col++) {
                    dp[row][col][rest] = dp[row - 1][col][rest - 1];
                    dp[row][col][rest] += dp[row + 1][col][rest - 1];
                    dp[row][col][rest] += dp[row][col - 1][rest - 1];
                    dp[row][col][rest] += dp[row][col + 1][rest - 1];
                }
            }
        }
        long all = (long) Math.pow(4, K);
        long live = dp[i + 1][j + 1][K];
        long gcd = gcd(all, live);
        return (live / gcd) + "/" + (all / gcd);
    }

    public static void main(String[] args) {
        int N = 10;
        int M = 10;
        int i = 3;
        int j = 2;
        int K = 5;
        System.out.println(bob1(N, M, i, j, K));
        System.out.println(bob2(N, M, i, j, K));
    }

}
