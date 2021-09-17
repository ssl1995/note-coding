package 力扣.剑指Offer.第三版.第1章_整数的基础知识.q3_前n个数字二进制中1的个数;

/**
 * @author SongShengLin
 * @date 2021/9/9
 */
public class Solution2 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 如果i是偶数，i是i/2左移一位的结果，因为i与i-1的二进制个数相同。
            // 如果i是奇数，i是i/2左移一位，然后最右边数字变为的结果，因为i比i-1的二进制个数多1。
            // 综上所述，i可以通过i/2的二进制个数来计算出i的二进制个数
            // i>>1:计算i/2
            // i&1:i%2,i如果是奇数，结果为1；i是偶数，结果是是0
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
