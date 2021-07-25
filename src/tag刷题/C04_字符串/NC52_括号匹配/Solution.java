package tag刷题.C04_字符串.NC52_括号匹配;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        // 特殊符号，放在栈底防止空指针
        map.put('#', '#');
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('#');
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (c != map.get(stack.pop())) {
                return false;
            }
        }
        // 栈存了特殊字符，最后长度判断是否长度为1
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        String s = "([)]";
        String s1 = "()[]{}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
        System.out.println(solution.isValid(s1));
    }

}
