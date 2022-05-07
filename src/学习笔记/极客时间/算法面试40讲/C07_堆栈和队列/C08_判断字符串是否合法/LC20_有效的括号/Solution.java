package 学习笔记.极客时间.算法面试40讲.C07_堆栈和队列.C08_判断字符串是否合法.LC20_有效的括号;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/16 8:28 AM
 * @description
 */
public class Solution {
    /**
     * 有效的括号
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || map.containsKey(c)) {
                stack.push(c);
            } else {
                if (map.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()";
        System.out.println(solution.isValid(s));
    }
}
