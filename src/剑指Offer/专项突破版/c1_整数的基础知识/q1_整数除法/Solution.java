package 剑指Offer.专项突破版.c1_整数的基础知识.q1_整数除法;

/**
 * @author SongShengLin
 * @date 2021/9/8
 */
public class Solution {

    public int divide(int a, int b) {
        if (a == 0x80000000 && b == -1) {// 越界：a=-2^31，b=-1是两个int越界相除的唯一情况
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        // int类型：-2^31,2^31-1
        // 由于int类型负数范围大于整数范围，如果a,b>0转化为负数
        if (a > 0) {
            negative--;
            a = -a;
        }
        if (b > 0) {
            negative--;
            b = -b;
        }
        int res = divideCore(a, b);
        return negative == 1 ? -res : res;
    }

    // 减法实现两个负数的除法
    private int divideCore(int a, int b) {
        int res = 0;
        while (a <= b) {// a=-15,b=-2.a<=b开始循环
            int value = b;// value为b的2倍、4倍、8倍
            int quotient = 1;// 商=1,2,3,4,5...
            // -2^30=0xc0000000,value不能超过它，否则负数减法会越界
            while (value >= 0xc0000000 && a <= value + value) {
                quotient += quotient;
                value += value;
            }
            res += quotient;
            a -= value;// 两个负数也是相减
        }
        return res;
    }
}
