package 学习笔记.极客时间.算法面试40讲.C26_BFS和DFS.C30_生成有效括号组合.LC22_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/18 8:43 AM
 * @description
 */
public class Solution {
    /**
     * 括号生成
     * 生成所有可能且有效的括号组合
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // n对括号，会生成2n长的字符串，使用dfs
        recursion(n, n, "", res);
        return res;
    }

    private void recursion(int leftNeed, int rightNeed, String subList, List<String> res) {
        if (leftNeed == 0 && rightNeed == 0) {
            res.add(subList);
            return;
        }
        // 还有需要的左括号，就添加左括号
        if (leftNeed > 0) {
            recursion(leftNeed - 1, rightNeed, subList + "(", res);
        }
        // 还需要左括号<还需要的右括号 = 已经生成的左括号>已经生成的右括号，还需要补充右括号
        if (leftNeed < rightNeed) {
            recursion(leftNeed, rightNeed - 1, subList + ")", res);
        }
    }
}
