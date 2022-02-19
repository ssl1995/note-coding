package 学习笔记.算法面试40讲.C41_2的幂次和比特位计数问题.LC231_2的幂;

/**
 * @author SongShengLin
 * @date 2022/2/19 10:25 PM
 * @description
 */
public class Solution {
    /**
     * 2的幂
     * 输入：n = 1
     * 输出：true
     * 解释：2^0 = 1
     */
    public boolean isPowerOfTwo(int n) {
        // 若是2的幂，n & n-1必为0 且 n>0
        return n > 0 && (n & n - 1) == 0;
    }
}
