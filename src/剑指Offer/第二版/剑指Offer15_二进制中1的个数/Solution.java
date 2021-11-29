package 剑指Offer.第二版.剑指Offer15_二进制中1的个数;

public class Solution {

    // n & 1 是最容易想到的方法
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {// n可为负数，循环条件是n!=0
            res += n & 1;
            n >>>= 1;// 无符号位移
        }
        return res;
    }

    // n & (n - 1)消除n最右边的1,速度更快
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);// 消除n最右边的1,一直消除到0结束
            res++;
        }
        return res;
    }
}
