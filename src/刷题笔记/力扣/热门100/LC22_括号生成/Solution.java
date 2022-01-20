package 刷题笔记.力扣.热门100.LC22_括号生成;

import java.util.LinkedList;
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
        List<String> res = new LinkedList<>();

        helper(n, n, "", res);
        return res;
    }

    /**
     * 往res中填生成的n对括号
     *
     * @param left    还需要生成的左括号数量
     * @param right   还需要生成的右括号数量
     * @param bracket 括号组合
     * @param res     结果集
     */
    private void helper(int left, int right, String bracket, List<String> res) {
        // base: 还需要生成的左右括号为0，表示当前一个完成的括号组合成功
        if (left == 0 && right == 0) {
            res.add(bracket);
            return;
        }
        // 已经生成的左括号<n，就还可能生成一个左括号
        if (left > 0) {
            helper(left - 1, right, bracket + "(", res);
        }
        // 已经生成的左括号<已经生成的右括号，就还可能生成一个右括号
        // 因为任意步骤中左括号必须 >= 右括号数量，比如 ()(还有机会、())必然无法匹配
        if (left < right) {
            helper(left, right - 1, bracket + ")", res);
        }
    }
}
