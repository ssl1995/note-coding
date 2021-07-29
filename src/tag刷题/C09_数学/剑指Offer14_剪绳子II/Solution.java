package tag刷题.C09_数学.剑指Offer14_剪绳子II;

public class Solution {

    // 法1:循环求余
    public int cuttingRope1(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        int p = 1000000007;
        long rem = 1;
        long x = 3;
        // a初始化均为n除3的段数-1
        int a = n / 3 - 1;
        // 循环求余:每一次rem%p
        for (int i = 1; i <= a; i++) {
            rem = (rem * x) % p;
        }
        // 此时n还剩一段3和余数(0 or 1 or 2)
        if (b == 0) {
            // 余数为0,直接乘3
            return (int) (rem * (3) % p);
        } else if (b == 1) {
            // 余数为1,3+1改成2+2,因为3*1<2*2
            return (int) (rem * (2 * 2) % p);
        } else {
            // 余数为2,3+2的最大值就是3*2
            return (int) (rem * (3 * 2) % p);
        }
    }

    // 法2:二分法求余
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        int p = 1000000007;
        long rem = 1;
        long x = 3;
        // 二分法求余:奇数次幂算余数,偶数次幂更新底数即可
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 != 0) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if (b == 0) {
            return (int) (rem * (3) % p);
        } else if (b == 1) {
            return (int) (rem * (2 * 2) % p);
        } else {
            return (int) (rem * (3 * 2) % p);
        }
    }
}
