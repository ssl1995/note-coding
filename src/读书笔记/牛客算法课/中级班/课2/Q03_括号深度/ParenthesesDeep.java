package 读书笔记.牛客算法课.中级班.课2.Q03_括号深度;

public class ParenthesesDeep {
    // 括号是否匹配，只包含()括号
    public static boolean isValid(char[] str) {
        if (str == null || str.equals("")) {
            return false;
        }
        int status = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ')' && str[i] != '(') {
                return false;
            }
            if (str[i] == ')' && --status < 0) {
                return false;
            }
            if (str[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }

    // 括号最大深度
    public static int deep(String s) {
        char[] str = s.toCharArray();
        if (!isValid(str)) {
            return 0;
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                max = Math.max(max, ++count);
            } else {
                count--;
            }
        }
        return max;
    }

    // 最长括号子串长度
    public static int maxLength(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] cs = str.toCharArray();
        // dp[i]:以i结束子串的有效匹配长度
        int[] dp = new int[cs.length];
        int pre;
        int res = 0;
        for (int i = 1; i < cs.length; i++) {
            // 显然匹配到(括号，以(结尾的子串没有有效长度，默认为0
            if (cs[i] == ')') {// 只有匹配到)括号才会有有效长度
                pre = i - dp[i - 1] - 1;// dp[i-1]的前一个位置
                if (pre >= 0 && cs[pre] == '(') {
                    // 还要+pre-1的有效长度
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "((()))";
        System.out.println(deep(test));

    }

}
