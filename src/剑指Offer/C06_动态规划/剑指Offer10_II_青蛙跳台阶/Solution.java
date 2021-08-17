package 剑指Offer.C06_动态规划.剑指Offer10_II_青蛙跳台阶;

public class Solution {

    // 一次可以跳1个台阶或者2个台阶
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
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
