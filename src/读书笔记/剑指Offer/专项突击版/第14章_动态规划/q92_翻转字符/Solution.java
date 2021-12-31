package 读书笔记.剑指Offer.专项突击版.第14章_动态规划.q92_翻转字符;

/**
 * @author SongShengLin
 * @date 2021/11/16 9:17 上午
 * @description
 */
public class Solution {

    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[2][2];
        // 第一行=f(i)：记录字符串下标从0到i的字符变成最后一个字符是0所需要的最少翻转次数
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        // 第二行=g(i)：记录字符串下标从0到i的字符变成最后一个字符是1所需要的最少翻转次数
        dp[1][0] = s.charAt(0) == '1' ? 0 : 1;

        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            // 先计算f(i-1)和g(i-1)
            int prev0 = dp[0][(i - 1) % 2];
            int prev1 = dp[1][(i - 1) % 2];

            // f(i)=f(i-1)+s[i]是0就不用翻转,是1就要翻转一次
            dp[0][i % 2] = prev0 + (c == '0' ? 0 : 1);
            // g(i)=min(f(i-1),g(i-1))+s[i]是1就不用翻转,是0就要翻转一次
            dp[1][i % 2] = Math.min(prev0, prev1) + (c == '1' ? 0 : 1);
        }
        // 取最后一列的最小值返回，就是翻转字符成递增字符串的最少次数
        return Math.min(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "00110";
        System.out.println(solution.minFlipsMonoIncr(s));
    }
}
