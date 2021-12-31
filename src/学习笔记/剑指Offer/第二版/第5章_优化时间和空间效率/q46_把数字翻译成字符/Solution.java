package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q46_把数字翻译成字符;

public class Solution {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 动态规划
     */
    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        // 将num转换为字符串
        String str = String.valueOf(num);
        int n = str.length();
        // dp[i]代表以xi为结尾的翻译数量,dp长度为n+1
        int[] dp = new int[n + 1];
        // 初始化dp[0]=dp[1]=1,表示“无数字”和"str第一位的翻译数量"
        // dp[0]=1怎么推?因为dp[1]=1,dp[2]要么=1,要么=2,当dp[2]=2时,dp[0]必为1
        dp[0] = dp[1] = 1;
        // 从第三位数开始遍历dp
        for (int i = 2; i <= n; i++) {
            // 原串str中拆分xi-1+xi组成的字符串subStr，注意下标变换
            String subStr = str.substring(i - 2, i);
            // 如果subStr可以整体翻译,说明subStr必须满足两位数10-25的要求，才能整体翻译
            if (subStr.compareTo("10") >= 0 && subStr.compareTo("25") <= 0) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {// 否则sub不能被翻译
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12258;
        System.out.println(solution.translateNum(n));
    }
}
