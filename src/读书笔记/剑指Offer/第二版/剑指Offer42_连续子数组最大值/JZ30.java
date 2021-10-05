package 读书笔记.剑指Offer.第二版.剑指Offer42_连续子数组最大值;

public class JZ30 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = array[i];
            } else {
                dp[i] = dp[i - 1] + array[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
