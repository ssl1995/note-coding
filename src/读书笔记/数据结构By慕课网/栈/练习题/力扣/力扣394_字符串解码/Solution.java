package 读书笔记.数据结构By慕课网.栈.练习题.力扣.力扣394_字符串解码;

import 读书笔记.数据结构By慕课网.树.LinkedList;

public class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> s_multi = new LinkedList<>();
        LinkedList<String> s_res = new LinkedList<>();
        for (char c : s.toCharArray()) {
            // 1.遇到左括号:s_multi和s_res保存上次数据
            if (c == '[') {
                s_multi.addLast(multi);
                s_res.addLast(res.toString());
                // 两个栈置空，便于获取当前次数和字符
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 2.遇到右括号：s_multi就出栈获得重复次数
                int cur_multi = s_multi.removeLast();
                // temp添加重复字符的结果
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < cur_multi; i++) {
                    temp.append(res);
                }
                // res = lastRes+temp
                res = new StringBuilder(s_res.removeLast() + temp);
            } else if (c >= '0' && c <= '9') {
                // 3.遇到0-9数字，转化成0-9整型数字+上一轮数字*10
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                // 4.遇到普通字符，直接加入当前res中
                res.append(c);
            }
        }
        return res.toString();
    }
}
