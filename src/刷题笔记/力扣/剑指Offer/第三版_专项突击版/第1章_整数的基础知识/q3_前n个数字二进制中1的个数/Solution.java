package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第1章_整数的基础知识.q3_前n个数字二进制中1的个数;

/**
 * @author SongShengLin
 * @date 2021/9/9
 */
public class Solution {

    /**
     * 比特位计数
     * [0,n]之间每个数的二进制有多少个1的个数
     * 法1：num&num-1将最右边的1变成0，计数+1
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = hammingWeight(i);
        }
        return res;
    }

    /**
     * 汉明码计数=位1的个数
     */
    private int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
