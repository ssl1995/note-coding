package 读书笔记.牛客算法课.中级班.课2.Q05_数字转换为字符串;

public class NumToStringWays {

    // 1对应 a，2对应b，…..26对应z,给一个数字，能转换成多少种字符串？
    // 注意：剑指Offer46，是0对应a,1对应b...25对应z

    public static int convertWays(int num) {
        if (num < 1) {
            return 0;
        }
        return process(String.valueOf(num).toCharArray(), 0);
    }

    // str[index...]往后能转换成多少种字符串？
    public static int process(char[] str, int index) {
        if (index == str.length) {// 越过n-1,就是一种有效的转换
            return 1;
        }
        if (str[index] == '0') {// 题目固定0不能转换
            return 0;
        }
        int res = process(str, index + 1);// index作为1个数转换
        if (index == str.length - 1) {
            return res;
        }
        if (((str[index] - '0') * 10 + str[index + 1] - '0') < 27) {// [index,index+1]作为一个数转换
            res += process(str, index + 2);
        }
        return res;
    }

    // 将暴力递归改成动态规划
    public static int dpways(int num) {
        if (num < 1) {
            return 0;
        }
        char[] cs = String.valueOf(num).toCharArray();
        int[] dp = new int[cs.length + 1];
        dp[cs.length] = 1;
        dp[cs.length - 1] = cs[cs.length - 1] == '0' ? 0 : 1;
        for (int i = cs.length - 2; i >= 0; i--) {
            if (cs[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1] + (((cs[i] - '0') * 10 + cs[i + 1] - '0') < 27 ? dp[i + 2] : 0);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int test = 111143311;
        System.out.println(convertWays(test));
        System.out.println(dpways(test));
    }

}
