package 学习笔记.剑指Offer.第二版.第3章_高质量代码.q15_二进制中1的个数;

/**
 * @author SongShengLin
 * @date 2021/12/12 12:57 AM
 * @description
 */
public class Solution {

    /**
     * 整数n的二进制中1的个数
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            // n-1 = 将n的二进制最右边的1变成0且如果该1右边有0，把所有1变成1
            // n&(n-1)将n的二进制最右边的1变成0，其余不变
            n &= n - 1;
        }
        return count;
    }
}
