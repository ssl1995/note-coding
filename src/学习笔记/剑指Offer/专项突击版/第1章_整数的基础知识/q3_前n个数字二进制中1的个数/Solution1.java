package 学习笔记.剑指Offer.专项突击版.第1章_整数的基础知识.q3_前n个数字二进制中1的个数;

/**
 * @author SongShengLin
 * @date 2021/9/9
 */
public class Solution1 {
    /**
     * 法2：i比 i&(i-1)的二进制多1
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        // 从1开始遍历，因为0没有前一个数
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
