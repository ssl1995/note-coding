package 力扣.剑指Offer.第二版.剑指Offer14_剪绳子II;

public class Solution {

    // 将长度为n的绳子等分为m段，使其乘积最大，m、n都是整数，n>1并且m>1，m<=n
    // 2 <= n <= 1000，此题的pow过程会越界
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        long rem = 1;// 余数,long类型
        int x = 3;// 底数为3
        int standard = 1000000007;// 题目规定的取余数
        // n= 3a + b -> a= n/3 - b/3 -> a= n/3 -1
        int a = n / 3 - 1;
        // 从1到a开始循环求余
        for (int i = 1; i <= a; i++) {
            rem = (rem * x) % standard;
        }
        // 剩下和剪绳子I类似啦，将I中的pow换成rem即可
        if (b == 0) {
            return (int) (rem * (3) % standard);
        } else if (b == 1) {
            return (int) (rem * (2 * 2) % standard);
        } else {
            return (int) (rem * (3 * 2) % standard);
        }
    }
}
