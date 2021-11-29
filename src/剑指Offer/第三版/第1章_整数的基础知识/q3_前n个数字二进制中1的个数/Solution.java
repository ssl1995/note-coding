package 剑指Offer.第三版.第1章_整数的基础知识.q3_前n个数字二进制中1的个数;

/**
 * @author SongShengLin
 * @date 2021/9/9
 */
public class Solution {
    // Q：[0,n]之间每个数的二进制有多少个1的个数
    // 法1：num&num-1将最右边的1变成0，计数+1
    public int[] countBits(int n) {
        // n=1，表示计算[0,1]的每个数字有多少个1，返回一个数组
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;// res的下标=每次计算二进制的num=j
            while (num != 0) {
                res[i]++;
                // 计算整数i的二进制1的个数最常用的方法：将num最右边的1变成0，直到num=0结束
                num = num & (num - 1);
            }
        }
        return res;
    }
}
