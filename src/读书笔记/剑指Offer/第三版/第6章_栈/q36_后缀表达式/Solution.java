package 读书笔记.剑指Offer.第三版.第6章_栈.q36_后缀表达式;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/6 8:40 下午
 * @description
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            // 长字符串放前面
            if (("+-*/").contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(cal(a, b, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private int cal(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}
