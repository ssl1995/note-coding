package 刷题笔记.力扣.热门100.LC22_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/1/20 11:51 PM
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
        // n对括号=会生成2n长的字符串，需要左括号数=右括号数=n
        recursion(n, n, "", res);
        return res;
    }

    private void recursion(int leftNeed, int rightNeed, String sub, List<String> res) {
        if (leftNeed == 0 && rightNeed == 0) {
            res.add(sub);
            return;
        }
        // 还需要添加左括号
        if (leftNeed > 0) {
            recursion(leftNeed - 1, rightNeed, sub + "(", res);
        }
        // 还需要添加右括号：还需要左括号<还需要的右括号 = 已经生成的左括号>已经生成的右括号
        if (leftNeed < rightNeed) {
            recursion(leftNeed, rightNeed - 1, sub + ")", res);
        }
    }
}
