package 读书笔记.数据结构By慕课网.栈.练习题.力扣.力扣71_简化路径;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        // 1.spilt分字符,然后遍历字符数组
        String[] splits = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : splits) {
            // 2.trim分割当前元素的前后空格
            String cur = s.trim();
            // 3.如果当前字符为空||为.，跳出当前循环
            if (cur == null || cur.length() == 0 || cur.equals(".")) {
                continue;
            }
            // 4.当前元素是..，非空栈就得出栈元素
            if (cur.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else { // 5.遍历到其他元素就入栈
                stack.push(cur);
            }
        }
        // 6.出栈，构成结果
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }
        // 7 res为空，返回”/“,否则返回res.toString
        return res.length() == 0 ? "/" : res.toString();
    }
}
