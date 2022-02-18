package 学习笔记.剑指Offer.专项突击版.第13章_回溯法.q85_生成匹配的括号;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/11 9:31 上午
 * @description
 */
public class Solution {
    /**
     * 题目：数字n代表生成括号的对数，生成所有可能的并且有效的括号组合。
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // n对括号，会生成2n长的字符串，使用dfs
        dfs(n, n, "", res);
        return res;
    }

    private void dfs(int leftNeed, int rightNeed, String subList, List<String> res) {
        if (leftNeed == 0 && rightNeed == 0) {
            res.add(subList);
            return;
        }
        // 还有需要的左括号，就添加左括号
        if (leftNeed > 0) {
            dfs(leftNeed - 1, rightNeed, subList + "(", res);
        }
        // 还需要左括号<还需要的右括号 = 已经生成的左括号>已经生成的右括号，还需要补充右括号
        if (leftNeed < rightNeed) {
            dfs(leftNeed, rightNeed - 1, subList + ")", res);
        }
    }
}
