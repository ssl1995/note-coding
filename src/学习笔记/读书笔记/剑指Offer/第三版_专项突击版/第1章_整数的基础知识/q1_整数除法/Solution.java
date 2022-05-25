package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第1章_整数的基础知识.q1_整数除法;

/**
 * @author SongShengLin
 * @date 2021/9/8
 */
public class Solution {

    public int divide(int a, int b) {
        // int范围：-2^31 到 2^31-1
        // 判断越界：如果a=-2^31，b=-1，a/b=2^31会产出越界
        // a=-2^31,转换成16进制：0x80000000，其中0x表示16进制，80000000表示16进制下的-2^31
        if (a == 0x80000000 && b == -1) {
            // 一旦越界，就返回最大的int整型值：2^31-1
            return Integer.MAX_VALUE;
        }
        // negative=1，表示负数
        int negative = 2;
        // 如果将负数转换成正数，存在溢出的问题；所以将所有正数转换为负数，就不会发生溢出
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
            int quotient = 1;
            // a每次最多减去b的2^value次：保证2^value < a < 2^(value+1)
            // value保证不越界：-2^30=0xc0000000,value不能超过它，否则负数减法会越界
            while (value >= 0xc0000000 && a <= value + value) {
                quotient += quotient;
                value += value;
            }
            res += quotient;
            a -= value;// 两个负数也是相减
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 15, b = 2;
        Solution solution = new Solution();
        System.out.println(solution.divide(a, b));
    }
}
