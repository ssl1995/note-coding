package 剑指Offer.分类版.C08_位运算.剑指Offer15_二进制中1的个数;

public class JZ11 {

    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);// 消除最右边的1，知道n为0为止
            res++;
        }
        return res;
    }
}
