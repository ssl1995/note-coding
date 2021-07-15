package 剑指Offer.正序版.剑指Offer15_二进制中1的个数;

public class Solution {

    // 法:n&(n-1)
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
