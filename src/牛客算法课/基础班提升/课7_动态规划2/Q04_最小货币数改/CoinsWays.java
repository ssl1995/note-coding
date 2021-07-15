package 牛客算法课.基础班提升.课7_动态规划2.Q04_最小货币数改;


public class CoinsWays {


    // Q:给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每一种都可以使用无限张，最终找零零钱数是aim
    // 求找零需要的方法数？
    // 暴力递归
    public static int way1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        // base case:index越界,如果rest=0,说明这就是一次成功的方法数
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        // 递归中出现了枚举行为,思考怎么改动态规划
        for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            ways += process(arr, index + 1, rest - arr[index] * zhang);
        }
        return ways;
    }

    // 记忆化搜索优化
    public static int way2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // base case:index越界,如果rest=0,说明这就是一次成功的方法数
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                // 改成二维表也还是枚举，还有其他优化的方法吗？
                for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
                    ways += dp[index + 1][rest - arr[index] * zhang];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }


    // 观察记忆表,优化枚举行为
    public static int way3(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // base case:index越界,如果rest=0,说明这就是一次成功的方法数
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                // 通过观察可以优化枚举行为,一个格子下方左边需要的格子可以由自己左边的格子替代
                dp[index][rest] = dp[index + 1][rest];// 一个格子总是需要自己下方的格子
                if (rest - arr[index] >= 0) {// 还需要自己本行,减去一个面值不越界的格子
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }


}
