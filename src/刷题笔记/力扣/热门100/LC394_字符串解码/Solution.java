package 刷题笔记.力扣.热门100.LC394_字符串解码;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    /**
     * 字符串编码
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     */
    public String decodeString(String s) {
        if (s == null) {
            return "";
        }
        // 括号内嵌套括号，体现栈的特性 = 先入后出
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> letterStack = new LinkedList<>();

        int num = 0;
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                numStack.push(num);
                letterStack.push(res.toString());

                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 3[a]2[bc]遇到第二个括号时，res=bc,num=2
                StringBuilder temp = new StringBuilder();
                int lastNum = numStack.pop();
                for (int i = 0; i < lastNum; i++) {
                    temp.append(res);
                }

                res = new StringBuilder(letterStack.pop() + temp);
            } else if (c >= '0' && c <= '9') {
                // 连续两个数字：形成一个整体
                num = num * 10 + (c - '0');
            } else {
                // 没有括号，只是字符，加到sb中
                res.append(c);
            }
        }

        return res.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3[a]2[bc]";
        System.out.println(solution.decodeString(s));
    }
}
