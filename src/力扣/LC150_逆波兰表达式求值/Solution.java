package 力扣.LC150_逆波兰表达式求值;


public class Solution {
    // tokens = ["2","1","+","3","*"]，输出9
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int index = -1;
        for (String str : tokens) {
            if (!"+-*/".contains(str)) {// 这里是contains,不是equals
                stack[++index] = Integer.parseInt(str);
            } else {
                int b = stack[index--];// 先出栈的是b
                int a = stack[index--];// 后出栈的是a，顺序一定不能错
                int num = cal(a, b, str);
                stack[++index] = num;
            }
        }
        return stack[index];
    }

    private int cal(int a, int b, String op) {
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
