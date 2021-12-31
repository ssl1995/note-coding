package 读书笔记.剑指Offer.专项突击版.第13章_回溯法.q86_分割回文子字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/12 9:21 上午
 * @description
 */
public class Solution {

    public String[][] partition(String s) {
        List<List<String>> list = new ArrayList<>();
        boolean[][] dp = isPalindrome(s);

        helper(s, 0, new ArrayList<>(), list, dp);

        return listTransformString(list);
    }

    private void helper(String s, int start, ArrayList<String> sub, List<List<String>> res, boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                sub.add(s.substring(start, i + 1));

                helper(s, i + 1, sub, res, dp);

                sub.remove(sub.size() - 1);
            }
        }
    }

    // 判断字符串的每个子串是否是回文，并返回dp表
    private boolean[][] isPalindrome(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();
        // dp[i][j]:表示s[i][j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：单独一个字符肯定是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 经验：dp区域是正方形的话，通常左下角区域无效不需要再填，因为走过的区域不用再走
        for (int j = 1; j < len; j++) { // 上三角区域，按列从上到下填
            for (int i = 0; i < j; i++) {
                // 首尾不相等时，必不是回文串
                if (cs[i] != cs[j]) {
                    dp[i][j] = false;
                } else {
                    // 首尾相等时，有2种情况
                    // 情况1：s[i...j]长度不超过3，不用检查必为回文串
                    // 情况2：s[i...j]长度大于3，由s[i+1...j-1]来判断
                    dp[i][j] = j - i + 1 <= 3 || dp[i + 1][j - 1];
                }
            }
        }
        return dp;
    }

    private String[][] listTransformString(List<List<String>> list) {
        String[][] res = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = new String[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "google";
        String[][] partition = solution.partition(s);
        System.out.println(Arrays.deepToString(partition));
    }
}
