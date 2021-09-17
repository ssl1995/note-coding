package 力扣.剑指Offer.第三版.第1章_整数的基础知识.q3_前n个数字二进制中1的个数;

/**
 * @author SongShengLin
 * @date 2021/9/9
 */
public class Solution {
    // Q：[0,n]之间每个数的二进制有多少个1的个数
    // 法1：num&num-1将最右边的1变成0，计数+1
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i;// res的下标=每次计算二进制的num=j
            while (j != 0) {
                res[i]++;
                // 将每个num最右边的1变成0
                j = j & (j - 1);
            }
        }
        return res;
    }
}
