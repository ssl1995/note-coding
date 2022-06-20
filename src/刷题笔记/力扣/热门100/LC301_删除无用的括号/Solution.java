package 刷题笔记.力扣.热门100.LC301_删除无用的括号;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2022/2/23 8:46 AM
 * @description
 */
public class Solution {

    private Set<String> set = new HashSet<>();
    private int n, max, len;
    private String str;

    /**
     * 删除无用的括号
     * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
     * 返回所有可能的结果。答案可以按 任意顺序 返回。
     * 输入：s = "()())()"
     * 输出：["(())()","()()()"]
     */
    public List<String> removeInvalidParentheses(String s) {
        str = s;
        n = s.length();
        // 左右括号数量
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                r++;
            }
        }
        // 最大得分：左右括号的最小值
        max = Math.min(l, r);

        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    /**
     * 递归生成有效的括号
     * @param index str下标
     * @param cur 组成的左右括号字符串
     * @param score 得分：遇到左括号+1分；遇到右括号-1分
     */
    private void dfs(int index, String cur, int score) {
        if (score < 0 || score > max) {
            return;
        }

        if (index == n) {
            if (score == 0 && cur.length() >= len) {
                if (cur.length() > len) {
                    set.clear();
                }
                len = cur.length();
                set.add(cur);
            }
            return;
        }

        char c = str.charAt(index);

        // 遇到左括号+1分；遇到右括号-1分
        if (c == '(') {
            dfs(index + 1, cur + c, score + 1);
            dfs(index + 1, cur, score);
        } else if (c == ')') {
            dfs(index + 1, cur + c, score - 1);
            dfs(index + 1, cur, score);
        } else {
            dfs(index + 1, cur + c, score);
        }
    }
}
