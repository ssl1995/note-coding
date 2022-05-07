package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第2章_面试需要的基础知识.q10_II_青蛙跳台阶;

public class Solution {

    /**
     * 青蛙跳台阶：一次可以跳1个台阶或者2个台阶
     */
    public int numWays(int n) {
        // 青蛙跳台阶，第一个台阶需要1次，第二个台阶需要2次
        // 隐式的告诉我们假设有第0个台阶，它也需要第跳1次，才能满足f(n)=f(n-1)+f(n-2)
        if (n == 0 || n == 1) {
            return 1;
        }
        // 由于前两项是f(0),f(1)都等于1，这是和斐波那契的区别
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
