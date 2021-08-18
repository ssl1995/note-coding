package 牛客算法课.基础班提升.课6_暴力递归到动态规划.Q01_机器人到达指定位置;

public class RobotWalk {
    // Q:假设有排成一行的N个位置,要求机器人只能向左or右,初始化在M位置,走k步到达P位置的方法数?

    // 方法1：暴力递归
    public static int way1(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        // 总共N个位置，从M点出发，还剩K步，返回最终能达到P的方法数
        return walk(N, M, K, P);
    }

    // N : 位置为1 ~ N，固定参数
    // cur : 当前在cur位置，可变参数
    // rest : 还剩res步没有走，可变参数
    // P : 最终目标位置是P，固定参数
    // 该函数的含义：只能在1~N这些位置上移动，当前在cur位置，走完rest步之后，停在P位置的方法数作为返回值返回
    public static int walk(int N, int cur, int rest, int P) {
        if (rest == 0) {// base case：剩余步数为0,cur来到p位置就返回1;否则返回0代表没有方法来到p位置
            return cur == P ? 1 : 0;
        }
        if (cur == 1) {// 边界1：cur来到1位置，只能想2位置走
            return walk(N, 2, rest - 1, P);
        }
        if (cur == N) {// 边界2：cur来到N位置，只能想N-1位置走
            return walk(N, N - 1, rest - 1, P);
        }
        // 一般情况：如果还有rest步要走，而当前的cur位置在中间位置上，那么当前这步可以走向左，也可以走向右
        // 走向左、走向右是截然不同的方法，所以总方法数要都算上
        return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);
    }

    // 法2：暴力递归优化成二维dp
    public static int way2(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        // base case：rest=0，cur来到p位置代表一个成功的方法数
        dp[0][P] = 1;
        for (int i = 1; i <= K; i++) {// i:剩余步数
            for (int j = 1; j <= N; j++) {// j:当前到达的位置
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        // 目标位置
        return dp[K][M];
    }

    // 法3：二维dp优化成一位dp
    public static int way3(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[P] = 1;
        for (int i = 1; i <= K; i++) {// 逐行扫描，一维dp从上到下只记录每一行的数值
            int leftUp = dp[1];// 左上角值初始化
            for (int j = 1; j <= N; j++) {
                int tmp = dp[j];//
                if (j == 1) {
                    dp[j] = dp[j + 1];
                } else if (j == N) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = leftUp + dp[j + 1];
                }
                leftUp = tmp;// 更新左上角的值
            }
        }
        return dp[M];// 返回扫描玩K行，第M列的值
    }

    public static void main(String[] args) {
        int n = 5, m = 2, k = 4, p = 4;
        System.out.println(way1(n, m, k, p));
        System.out.println(way2(n, m, k, p));
        System.out.println(way3(n, m, k, p));
    }

}
