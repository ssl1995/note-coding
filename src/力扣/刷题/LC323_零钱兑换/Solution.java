package 力扣.刷题.LC323_零钱兑换;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        return process(coins, 0, amount);
    }

    // 暴力递归：arr[i...n-1]找零rest需要的最少张数
    private int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;
        for (int k = 0; k * arr[i] <= rest; k++) {
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, amount));
    }
}
