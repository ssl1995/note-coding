package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q65_不用加减乘除做加法;

public class Solution {


    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     */
    public int add(int a, int b) {
        int sum;
        while (b != 0) {
            // 无进位相加=异或结果
            sum = a ^ b;
            // 进位信息=位与操作，再左移一位
            b = (a & b) << 1;
            a = sum;
        }
        // b==0跳出循环，返回a
        return a;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        Solution solution = new Solution();
        System.out.println(solution.add(a, b));
    }

}
