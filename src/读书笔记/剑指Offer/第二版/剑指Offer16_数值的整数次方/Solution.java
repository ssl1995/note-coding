package 读书笔记.剑指Offer.第二版.剑指Offer16_数值的整数次方;

public class Solution {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0.0;
        }
        if (x == 1) {
            return 1.0;
        }
        // b指向幂次n，由于n=−2147483648时, n=-n会溢出，所以设b是long类型
        long b = n;
        // n为负数幂时，x取倒数，b=-b变成正数
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {// 这里b=|b|,循环条件>0即可；如果b能为负数，循环条件是b!=0
            if ((b & 1) == 1) {// bi=1时，res乘xi
                res *= x;
            } else {// bi=0时,res乘1
                res *= 1;
            }
            // b有多少位二进制数，x就乘多少次
            x *= x;
            // b二进制位右移一位,因为此时b=|b|,有符号右移还是无符号右移都行
            b >>= 1;
        }
        return res;
    }
}
