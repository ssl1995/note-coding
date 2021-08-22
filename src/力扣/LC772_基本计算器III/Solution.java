package 力扣.LC772_基本计算器III;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);// 加减优先级最低
        put('+', 1);
        put('*', 2);// 乘除求余优先级中等
        put('/', 2);
        put('%', 2);
        put('^', 3);// 幂次优先级最高
    }};

    // LC227 基本计算器II,字符串只包含非负整数
    // LC772 基本计算器III,字符串只包含非负整数
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        Deque<Character> ops = new ArrayDeque<>();
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {// 遇到左括号
                ops.addLast(c);
            } else if (c == ')') {// 遇到右括号
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        cal(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else if (Character.isDigit(c)) {// 遇到数字
                int num = 0;
                int j = i;
                while (j < n && Character.isDigit(cs[j])) {// 字符数字所有数字部分，全部放一起
                    num = num * 10 + (cs[j++] - '0');
                }
                nums.addLast(num);
                i = j - 1;
            } else {// 遇到操作符
                // 防止(...)出现类似(-..)等情况，优先加入0防止
                if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                    nums.addLast(0);
                }
                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    char top = ops.peekLast();
                    if (map.get(top) >= map.get(c)) {// 栈顶优先级>=待加入操作符，就计算
                        cal(nums, ops);
                    } else {
                        break;
                    }
                }
                ops.addLast(c);
            }
        }
        while (!ops.isEmpty() && ops.peekLast() != '(') {// 遍历cs结束，操作符栈非空，就继续计算
            cal(nums, ops);
        }
        return nums.peekLast();
    }

    private void cal(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        int res = 0;
        if (op == '+') {
            res = a + b;
        } else if (op == '-') {
            res = a - b;
        } else if (op == '*') {
            res = a * b;
        } else if (op == '/') {
            res = a / b;
        } else if (op == '^') {// 求幂次
            res = (int) Math.pow(a, b);
        } else if (op == '%') {// 求余
            res = a % b;
        }
        nums.addLast(res);
    }

}
