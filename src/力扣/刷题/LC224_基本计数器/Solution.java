package 力扣.刷题.LC224_基本计数器;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // 输入：s = "(1+(4+5+2)-3)+(6+8)" 只有加减的操作符，返回计算结果
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();// 数字栈存数字
        nums.addLast(0);// 防止第一个数是负数，先往数字栈中加入0
        Deque<Character> ops = new ArrayDeque<>();// 操作符栈存操作符和括号
        s = s.replace(" ", "");
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {// 遇到左括号
                ops.addLast(c);
            } else if (c == ')') {// 遇到右括号
                while (!ops.isEmpty()) {
                    char top = ops.peekLast();
                    if (top != '(') {
                        cal(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else if (Character.isDigit(c)) {// 遇到数字
                int num = 0;
                int j = i;
                while (j < n && Character.isDigit(cs[j])) {// 字符数组取出连续整数
                    num = num * 10 + (cs[j++] - '0');
                }
                nums.addLast(num);
                i = j - 1;// 更新遍历指针i
            } else {// 遇到操作符
                // 防止(..)括号内第一字符是操作符，数字栈+0,变换为(+0)类似形式
                if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                    nums.addLast(0);
                }
                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    cal(nums, ops);
                }
                ops.addLast(c);
            }
        }
        while (!ops.isEmpty()) {
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
        nums.addLast(op == '+' ? a + b : a - b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(1+(4+5+2)-3)+(6+8)";
        String s1 = "2-1 + 2 ";
        System.out.println(solution.calculate(s));
        System.out.println(solution.calculate(s1));
    }
}
