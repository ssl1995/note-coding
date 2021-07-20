package tag刷题.C04_字符串.NC150_逆波兰表达式求值;

import java.util.LinkedList;

public class Solution {
    // tokens = ["2","1","+","3","*"]，输出9
    // 数组模拟栈:速度最快
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

    // 用Api的栈
    public int evalRPN1(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if ("+-*/".contains(s)) {
                int b = stack.pop();// 先出栈的是操作数2
                int a = stack.pop();// 后出栈的是操作数1
                stack.push(calculate(a, b, s));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        // 遍历完tokens字符数组，stack中只剩一个数字，就是结果
        return stack.pop();
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

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }

}
