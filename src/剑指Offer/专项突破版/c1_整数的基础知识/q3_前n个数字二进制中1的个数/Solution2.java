package 剑指Offer.专项突破版.c1_整数的基础知识.q3_前n个数字二进制中1的个数;

/**
 * @author SongShengLin
 * @date 2021/9/9
 */
public class Solution2 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 如果i是偶数，i与i-1的二进制个数相同
            // 如果i是奇数，i比i-1的二进制个数多1
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
