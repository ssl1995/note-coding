package 剑指Offer.剑指Offer65_不用加减乘除做加法;

public class Solution {

    // 法1:迭代法,面试首选迭代法
    public int add1(int a, int b) {
        // sum保存无进位和
        int sum = 0;
        // b保存进位结果
        // 进位b=0时,停止循环
        while (b != 0) {
            // a+b= a与b的进位+a与b的无进位和
            // a与b的进位 = a&&b的值相同
            // a与b的无进位和 = a^b的值相同
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }

    // 法2:递归法
    public int add2(int a, int b) {
        // b=0时，返回a
        if (b == 0) {
            return a;
        }
        // a+b= a与b的进位+a与b的无进位和,可以直接修改成递归
        return add2(a ^ b, (a & b) << 1);
    }


}
