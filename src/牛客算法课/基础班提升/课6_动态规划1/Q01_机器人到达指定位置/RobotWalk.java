package 牛客算法课.基础班提升.课6_动态规划1.Q01_机器人到达指定位置;

public class RobotWalk {
    // Q:假设有排成一行的N个位置,要求机器人只能向左or右,初始化在M位置,走k步到达P位置的方法数?

    // 方法1：暴力递归
    public static int ways1(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        // 总共N个位置，从M点出发，还剩K步，返回最终能达到P的方法数
        return walk1(N, M, K, P);
    }

    // N : 位置为1 ~ N，固定参数
    // cur : 当前在cur位置，可变参数
    // rest : 还剩res步没有走，可变参数
    // P : 最终目标位置是P，固定参数
    // 该函数的含义：只能在1~N这些位置上移动，当前在cur位置，走完rest步之后，停在P位置的方法数作为返回值返回
    public static int walk1(int N, int P, int cur, int rest) {
        // 如果没有剩余步数了，当前的cur位置就是最后的位置
        // 如果最后的位置停在P上，那么之前做的移动是有效的
        // 如果最后的位置没在P上，那么之前做的移动是无效的
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        // 如果还有rest步要走，而当前的cur位置在1位置上，那么当前这步只能从1走向2
        // 后续的过程就是，来到2位置上，还剩rest-1步要走
        if (cur == 1) {
            return walk1(N, P, 2, rest - 1);
        }
        // 如果还有rest步要走，而当前的cur位置在N位置上，那么当前这步只能从N走向N-1
        // 后续的过程就是，来到N-1位置上，还剩rest-1步要走

        // 如果还有rest步要走，而当前的cur位置在中间位置上，那么当前这步可以走向左，也可以走向右
        // 走向左之后，后续的过程就是，来到cur-1位置上，还剩rest-1步要走
        // 走向右之后，后续的过程就是，来到cur+1位置上，还剩rest-1步要走
        // 走向左、走向右是截然不同的方法，所以总方法数要都算上
        return walk1(N, P, cur + 1, rest - 1) + walk1(N, P, cur - 1, rest - 1);
    }


    // 方法11:记忆化搜索表,优化方法1
    public static int ways11(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        // k:剩余步数,N:N行位置
        int[][] dp = new int[K + 1][N + 1];
        // 初始化为-1,标识没有命中缓存
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        // 调用记忆化搜索表
        return walk11(N, P, K, M, dp);
    }

    public static int walk11(int N, int E, int rest, int cur, int[][] dp) {
        // 如果之前计算过该位置的结果,直接返回该结果:记忆过的不用再计算
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        // 缓存没命中,每一次都将你要计算的结果放在你的格子里
        if (rest == 0) {
            dp[rest][cur] = cur == E ? 1 : 0;
        } else if (cur == 1) {
            dp[rest][cur] = walk11(N, E, rest - 1, 2, dp);
        } else if (cur == N) {
            dp[rest][cur] = walk11(N, E, rest - 1, N - 1, dp);
        } else {
            dp[rest][cur] = walk11(N, E, rest - 1, cur - 1, dp) + walk11(N, E, rest - 1, cur + 1, dp);
        }
        return dp[rest][cur];
    }

    // 通过记忆化搜索表,看着表结构优化,尝试出状态转移方程
    public static int ways2(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        // base case
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

    public static int ways3(int N, int M, int K, int P) {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[P] = 1;
        for (int i = 1; i <= K; i++) {
            int leftUp = dp[1];// 左上角的值
            for (int j = 1; j <= N; j++) {
                int tmp = dp[j];
                if (j == 1) {
                    dp[j] = dp[j + 1];
                } else if (j == N) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = leftUp + dp[j + 1];
                }
                leftUp = tmp;
            }
        }
        return dp[M];
    }

    public static void main(String[] args) {
        System.out.println(ways1(7, 4, 9, 5));
        System.out.println(ways2(7, 4, 9, 5));
        System.out.println(ways3(7, 4, 9, 5));
    }

}
