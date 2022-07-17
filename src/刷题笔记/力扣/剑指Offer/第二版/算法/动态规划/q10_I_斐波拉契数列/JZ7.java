package 刷题笔记.力扣.剑指Offer.第二版.算法.动态规划.q10_I_斐波拉契数列;

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
