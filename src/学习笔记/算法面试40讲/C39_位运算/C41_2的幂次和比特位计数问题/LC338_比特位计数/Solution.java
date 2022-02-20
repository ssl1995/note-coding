package 学习笔记.算法面试40讲.C39_位运算.C41_2的幂次和比特位计数问题.LC338_比特位计数;

/**
 * @author SongShengLin
 * @date 2022/2/19 10:26 PM
 * @description
 */
public class Solution {
    /**
     * LC338_比特位计数
     * 输入：n = 2
     * 输出：[0,1,1]
     * 解释：返回0到n中每个数中1的个数
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
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
