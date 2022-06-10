package 刷题笔记.力扣.热门100.LC32_最长有效括号;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2022/1/22 11:10 PM
 * @description
 */
public class Solution {
    /**
     * 最长有效括号
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     */
    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int max = 0;
        // 栈：左括号直接存下标,保证栈底为最后一个没有被匹配的右括号的下标
        LinkedList<Integer> stack = new LinkedList<>();
        // 栈底初始化放坐标=-1，防止只有)括号放入
        stack.push(-1);

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            // 遇到(，栈中存下标
            if (cs[i] == '(') {
                stack.push(i);
            } else if (cs[i] == ')') {
                // 遇到)，出栈
                stack.pop();

                // 栈空，说明初始化-1的坐标已取出=)没有成功匹配到(
                if (stack.isEmpty()) {
                    // 栈底存最近一个没有匹配成功的右括号下标
                    stack.push(i);
                } else {
                    // 栈非空，说明()括号匹配成功
                    // 更新长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = ")()())";
        System.out.println(solution.longestValidParentheses(s));
    }
}
