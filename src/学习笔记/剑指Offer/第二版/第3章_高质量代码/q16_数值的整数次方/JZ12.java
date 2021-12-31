package 学习笔记.剑指Offer.第二版.第3章_高质量代码.q16_数值的整数次方;

public class JZ12 {
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0.0;
        }
        if (base == 1) {
            return 1.0;
        }
        long b = exponent;
        if (b < 0) {
            base = 1 / base;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {// 这里b=|b|,循环条件>0即可；如果b能为负数，循环条件是b!=0
            if ((b & 1) == 1) {// bi=1时，res乘xi
                res *= base;
            } else {// bi=0时,res乘1
                res *= 1;
            }
            // b有多少位二进制数，base就乘多少次
            base *= base;
            // b二进制位右移一位,因为此时b=|b|,有符号右移还是无符号右移都行
            b >>= 1;
        }
        return res;
    }
}
