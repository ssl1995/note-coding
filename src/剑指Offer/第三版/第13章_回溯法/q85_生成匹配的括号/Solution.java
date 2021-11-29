package 剑指Offer.第三版.第13章_回溯法.q85_生成匹配的括号;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/11 9:31 上午
 * @description
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();

        helper(n, n, "", res);
        return res;
    }

    private void helper(int left, int right, String s, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        // 原则1：0<左括号<n，可以加左括号
        if (left > 0) {
            helper(left - 1, right, s + "(", res);
        }
        // 原则2：左括号<右括号，才能添加右括号
        if (left < right) {
            helper(left, right - 1, s + ")", res);
        }
    }
}
