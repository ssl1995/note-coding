package 剑指Offer.正序版.剑指Offer46_把数字翻译成字符;

public class Solution {
    // 注意:0-a,1-b,...,25-z
    // 动态规划:最容易理解的写法
    public int translateNum1(int num) {
        // 将num转换为字符串
        String str = String.valueOf(num);
        int n = str.length();
        // dp[i]代表以xi为结尾的翻译数量,dp长度为n+1
        // 初始化dp[0]=dp[1]=1,表示“无数字”和"str第一位的翻译数量"
        // dp[0]=1怎么推?因为dp[1]=1,dp[2]要么=1,要么=2,当dp[2]=2时,dp[0]必为1
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        // 从第三位数开始遍历
        for (int i = 2; i <= n; i++) {
            // 拆分xi-1+xi组成的字符串subStr
            String subStr = str.substring(i - 2, i);
            // 如果subStr可以整体翻译,dp[i]=dp[i-1]+dp[i-2]
            // 如果subStr不能整体翻译,dp[i]=dp[i-1]
            int count = (subStr.compareTo("10") >= 0 && subStr.compareTo("25") <= 0) ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            dp[i] = count;
        }
        return dp[n];
    }

    // 动态规划:将上述方法dp数组转化两个数迭代
    public int translateNum2(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int a = 1;// 表示dp[i-2]
        int b = 1;// 表示dp[i-1]
        for (int i = 2; i <= n; i++) {
            String subStr = str.substring(i - 2, i);
            int count = (subStr.compareTo("10") >= 0 && subStr.compareTo("25") <= 0) ? a + b : b;
            a = b;
            b = count;
        }
        // 返回b,因为b每次保存count
        return b;
    }
}
