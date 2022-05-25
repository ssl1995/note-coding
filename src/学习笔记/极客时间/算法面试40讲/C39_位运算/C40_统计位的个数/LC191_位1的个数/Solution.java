package 学习笔记.极客时间.算法面试40讲.C39_位运算.C40_统计位的个数.LC191_位1的个数;

/**
 * @author SongShengLin
 * @date 2022/2/19 8:01 PM
 * @description
 */
public class Solution {
    /**
     * 位1的个数
     * 输入：00000000000000000000000000001011
     * 输出：3
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
