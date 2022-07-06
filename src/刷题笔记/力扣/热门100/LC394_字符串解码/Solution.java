package 刷题笔记.力扣.热门100.LC394_字符串解码;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    /**
     * 字符串编码
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     */
    public String decodeString(String s) {
        if (s == null) {
            return "";
        }
        // 栈1：保存遇到的倍数数字
        Deque<Integer> numStack = new LinkedList<>();
        // 栈2：保存已经生成好的字符串
        Deque<String> letterStack = new LinkedList<>();

        // num保存遇到左括号前的数字=倍数
        int multi = 0;
        // res在本方法返回之作为保存[]之间，临时字符的功能
        StringBuilder res = new StringBuilder();

        // s = "3[a2[c]]"
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                // 遇到数字
                // num记录数字值
                multi = multi * 10 + (c - '0');
            } else if (c == '[') {
                // 遇到左括号

                // 记录之前的倍数num=multi
                numStack.push(multi);
                // 记录之前生成的字符串结果
                letterStack.push(res.toString());

                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 遇到右括号
                StringBuilder temp = new StringBuilder();
                int lastNum = numStack.pop();
                for (int i = 0; i < lastNum; i++) {
                    temp.append(res);
                }

                res = new StringBuilder(letterStack.pop() + temp);
            } else {
                // 遇到字符
                res.append(c);
            }
        }

        return res.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3[a2[c]]";
        // accaccacc
        System.out.println(solution.decodeString(s));
    }
}
