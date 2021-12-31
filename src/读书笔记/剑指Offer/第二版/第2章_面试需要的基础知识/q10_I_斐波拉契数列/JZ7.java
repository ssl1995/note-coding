package 读书笔记.剑指Offer.第二版.第2章_面试需要的基础知识.q10_I_斐波拉契数列;

public class JZ7 {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
