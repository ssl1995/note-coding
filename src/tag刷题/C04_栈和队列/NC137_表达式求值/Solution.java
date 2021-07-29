package tag刷题.C04_栈和队列.NC137_表达式求值;

import java.util.*;

public class Solution {

    // 请写一个整数计算器，支持加减乘三种运算和括号
    public int solve(String s) {
        return evalRPN(toSuffix(s));
    }

    // 中缀表达式转换为后缀表达式
    // 比如：(2*(3-4))*5 -> 234-*5*
    private String[] toSuffix(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 0);// 栈外，左括号优先级最低；栈内，左括号优先级最高
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        // 队列：存后缀表达式
        LinkedList<String> queue = new LinkedList<>();
        // 栈：存运算符
        LinkedList<Character> stack = new LinkedList<>();
        char[] cs = s.trim().toCharArray();
        String ops = "+-*/()";
        char ch;
        int len = 0;// 记录加入queue中的表达式长度
        for (int i = 0; i < cs.length; i++) {
            ch = cs[i];
            if (Character.isDigit(ch) || Character.isLetter(ch) || ch == '.') {// 遇到数字/字母/小数点,len++
                len++;
            } else if (Character.isSpaceChar(ch)) {// 遇到空格
                if (len > 0) {// 有数字等就入队列
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len, i)));
                    len = 0;
                }
                continue;
            } else if (ops.contains(String.valueOf(ch))) {// 遇到+-*/()这6种表达式
                if (len > 0) {// 有数字等就入队列
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len, i)));
                    len = 0;
                }
                if (ch == '(') {// 遇见(先入栈
                    stack.push(ch);
                    continue;
                }
                if (!stack.isEmpty()) {// 遇见)前，或者没有遇到()且早就遇到过了+-*/就要出栈，入队列记录后缀表达式
                    boolean flag = false;// 标记是否遇到()括号
                    // 如ch为),则一直出栈入队列，直到遇到(
                    while (!stack.isEmpty() && ch == ')' && stack.peek() != '(') {
                        queue.add(String.valueOf(stack.pop()));
                        flag = true;
                    }
                    // 如果没有遇到()括号，栈内优先级>=栈外，栈内操作数出栈，入队列记录后缀表达式
                    while (!stack.isEmpty() && !flag && map.get(stack.peek()) >= map.get(ch)) {
                        queue.add(String.valueOf(stack.pop()));
                    }
                }
                // 遇见)就出栈
                if (ch == ')') {
                    stack.pop();
                } else {// 到这里只能遇到+-*/啦，就入栈
                    stack.push(ch);
                }
            }
            // 如果i遍历到字符数组末尾
            if (i == cs.length - 1) {
                if (len > 0) {// 还有数字记录，就入队列
                    // 中缀表达式最后面只能是数字或者右括号，这里len>0，所以只能是最后还有数字
                    // 所以是从i-len+1(数字本身作为起点)，到i+1(作为终点)
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len + 1, i + 1)));
                }
                while (!stack.isEmpty()) {// 接着，把操作数数依次出栈放入队列
                    queue.add(String.valueOf(stack.pop()));
                }
            }
        }
        // 返回字符串数组
        return queue.toArray(new String[0]);
    }

    // 力扣150后缀表达式求值：支持+-*/
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

    public static void main(String[] args) {
        String s = "(2*(3-4))*5";
        Solution solution = new Solution();
        System.out.println(solution.solve(s));
    }


}
