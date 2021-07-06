package 剑指Offer.剑指Offer16_数值的整数次方;

public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        // b指向幂次，由于n=−2147483648时, n=-n会溢出，所以b是long类型
        long b = n;
        // 返回值初始化1.0
        double res = 1.0;
        // n为负数时的幂次
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }
        // 但幂次b判断完最左边二进制位后,结束
        while (b != 0) {
            // 计算b最右边的二进制位数是0还是1
            // b最右边二进制是1,乘以x
            if ((b & 1) == 1) {
                res *= x;
            } else {// b最右边二进制是0,乘以1
                res *= 1;
            }
            // x=x^2
            x = x * x;
            // b二进制位右移一位,因为此时b=|b|,有符号右移还是无符号右移都行
            b >>= 1;
        }
        return res;
    }
}
