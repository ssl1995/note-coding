package 学习笔记.剑指Offer.第二版.第2章_面试需要的基础知识.q14_剪绳子II;

public class Solution {

    /**
     * 就n划分为m段(m,n均>1),求划分成m段后，各段乘积最大值
     * n的取值范围：2 <= n <= 1000，此题的pow过程会越界
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        // 取a中3个个数-1，因为后面rem*3等，留了一个空位出来
        int a = n / 3 - 1;
        int b = n % 3;
        int x = 3;
        // 题目规定的取余数
        int p = 1000000007;
        // 循环求余法
        long rem = reminder(x, a, p);
        // 剩下和剪绳子I类似啦，将I中的pow换成rem即可
        if (b == 0) {
            return (int) (rem * (3) % p);
        } else if (b == 1) {
            return (int) (rem * (2 * 2) % p);
        }
        return (int) (rem * (3 * 2) % p);

    }


    /**
     * 循环求余法：(x^a)%p的余数=rem
     */
    private long reminder(int x, int a, int p) {
        long rem = 1;
        for (int i = 1; i <= a; i++) {
            // 余数是等于，不能加
            rem = (rem * x) % p;
        }
        return rem;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reminder(1000000006, 1, 1000000007));
        System.out.println(solution.reminder(1000000006, 2, 1000000007));
//        System.out.println(solution.cuttingRope(5));
    }
}
