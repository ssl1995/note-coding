package tag刷题.C04_字符串.NC137_表达式求值;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // Q：请写一个整数计算器，支持加减乘三种运算和括号
    public int solve(String s) {
        return evalRPN(toSuffix(s));
    }

    // 中缀表达式转换为后缀表达式
    // a+b -> ab+
    // (2*(3-4))*5 -> 234-*5*
    private String[] toSuffix(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        // 存数字和最后的后缀表达式
        LinkedList<String> queue = new LinkedList<>();
        // 栈存运算符
        LinkedList<Character> stack = new LinkedList<>();
        char[] cs = s.trim().toCharArray();
        String standard = "+-*/()";
        char ch;
        int len = 0;// 记录加入queue中的表达式长度
        for (int i = 0; i < cs.length; i++) {
            ch = cs[i];
            if (Character.isDigit(ch) || Character.isLetter(ch) || ch == '.') {// 遇到数字/字母/小数点,len++
                len++;
            } else if (Character.isSpaceChar(ch)) {// 遇到空格
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len, i)));
                    len = 0;
                }
                continue;
            } else if (standard.contains(String.valueOf(ch))) {// 遇到+-*/()这6种表达式
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len, i)));
                    len = 0;
                }
                if (ch == '(') {// 遇见(先入栈
                    stack.push(ch);
                    continue;
                }
                if (!stack.isEmpty()) {// 如果栈不为空，说明之前存了其他运算符，需要出栈
                    boolean flag = false;
                    // 如ch为),则一直出栈直到遇到(
                    while (!stack.isEmpty() && ch == ')' && stack.peek() != '(') {
                        queue.add(String.valueOf(stack.pop()));
                        flag = true;//设置标志位，标记取的是()中的元素
                    }
                    // 如果不是去()中的元素
                    while (!stack.isEmpty() && !flag && map.get(stack.peek()) >= map.get(ch)) {
                        queue.add(String.valueOf(stack.pop()));
                    }
                }
                if (ch != ')') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
            if (i == cs.length - 1) {
                if (len > 0) {// 如果走到中缀表达式最后一位，len>0说明遇到数字，放入queue中
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len + 1, i + 1)));
                }
                while (!stack.isEmpty()) {
                    queue.add(String.valueOf(stack.pop()));
                }
            }
        }
        // 返回字符串数组
        return queue.toArray(new String[0]);
    }

    // 力扣150后缀表达式求值
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        // 数组stack从0开始，初始化i=-1
        int i = -1;
        for (String s : tokens) {
            if ("+-*/".contains(s)) {
                int b = stack[i--];// 先出栈的是操作数2
                int a = stack[i--];// 后出栈的是操作数1
                stack[++i] = calculate(a, b, s);
            } else {
                stack[++i] = Integer.parseInt(s);
            }
        }
        // 遍历完tokens字符数组，stack中只剩一个数字，就是结果
        return stack[i];
    }

    private int calculate(int a, int b, String op) {
        if ("+".equals(op)) {
            return a + b;
        } else if ("-".equals(op)) {
            return a - b;
        } else if ("*".equals(op)) {
            return a * b;
        } else if ("/".equals(op)) {
            return a / b;
        }
        return -1;
    }


}
