package 剑指Offer.C06_动态规划.剑指Offer46_把数字翻译成字符;

public class Solution {
    // 注意:0-a,1-b,...,25-z，给一个数字，能转换为多少种字符串？

    // 递归法
    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        String str = String.valueOf(num);
        char[] cs = str.toCharArray();
        return process(cs, 0);
    }

    private int process(char[] cs, int index) {
        if (index == cs.length) {// index越过len-1，说明就是一种有效的转换
            return 1;
        }
        int count = process(cs, index + 1);
        if (index == cs.length - 1) {
            return count;
        }
        if ((cs[index] - '0') * 10 + (cs[index + 1] - '0') <= 25 && (cs[index] - '0') * 10 + (cs[index + 1] - '0') >= 10) {
            count += process(cs, index + 2);
        }
        return count;
    }

    // 将递归改成动态规划:dp[i]=dp[i-2]+dp[i-1] or dp[i-1]
    public int translateNum1(int num) {
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
            // 如果subStr可以整体翻译,说明subStr值需要[10,25]
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
        System.out.println(solution.translateNum1(n));
    }
}
