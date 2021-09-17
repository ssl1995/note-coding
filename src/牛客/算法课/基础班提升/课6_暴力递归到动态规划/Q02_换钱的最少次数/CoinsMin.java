package 牛客.算法课.基础班提升.课6_暴力递归到动态规划.Q02_换钱的最少次数;

public class CoinsMin {

    // Q：给定一个整数aim(正数不重复)，代表要找的钱数，求组成 aim 的最少货币数?
    // 法1：暴力递归
    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    // 当前考虑的面值是arr[i]，还剩rest的钱需要找零
    // 如果返回-1说明自由使用arr[i..N-1]面值的情况下，无论如何也无法找零rest
    // 如果返回不是-1，代表自由使用arr[i..N-1]面值的情况下，找零rest需要的最少张数
    public static int process(int[] arr, int i, int rest) {
        // base case：i来到len，rest剩余钱为0返回0代表成功，返回-1代表失败
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        // 最少张数，初始时为-1，因为还没找到有效解
        int res = -1;
        // 依次尝试使用当前面值(arr[i])0张、1张、k张，但不能超过rest
        for (int k = 0; k * arr[i] <= rest; k++) {
            int next = process(arr, i + 1, rest - k * arr[i]);// 使用了k张arr[i]，剩下的钱为rest - k * arr[i]
            if (next != -1) { // next有效：返回非-1
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }

    // 法2：动态规划
    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // 设置最后一排的值，除了dp[N][0]为0之外，其他都是-1
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        for (int i = N - 1; i >= 0; i--) { // 从底往上计算每一行
            for (int rest = 0; rest <= aim; rest++) { // 每一行都从左往右
                dp[i][rest] = -1; // 初始时先设置dp[i][rest]的值无效
                if (dp[i + 1][rest] != -1) { // 下面的值如果有效
                    dp[i][rest] = dp[i + 1][rest]; // dp[i][rest]的值先设置成下面的值
                }
                // 左边的位置不越界并且有效
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) { // 如果之前下面的值无效
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else { // 说明下面和左边的值都有效，取最小的
                        dp[i][rest] = Math.min(dp[i][rest],
                                dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 3};
        int aim = 20;
        System.out.println(minCoins1(arr, aim));
        System.out.println(minCoins2(arr, aim));
    }
}
