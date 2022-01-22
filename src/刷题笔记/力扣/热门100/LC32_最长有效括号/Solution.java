package 刷题笔记.力扣.热门100.LC32_最长有效括号;

/**
 * @author SongShengLin
 * @date 2022/1/22 11:10 PM
 * @description
 */
public class Solution {
    /**
     * 最长有效括号
     */
    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int[] dp = new int[s.length()];
        int max = 0;
        int pre;
        for (int i = 1; i < s.length(); i++) {
            // 当前遍历到),才有可能有匹配括号
            if (cs[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && cs[pre] == '(') {
                    // pre还有，就再加上dp[pre-1]
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()(()())";
        System.out.println(solution.longestValidParentheses(s));
    }
}
