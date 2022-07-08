package 刷题笔记.力扣.热门100.LC338_比特位计算;

/**
 * @author SongShengLin
 * @date 2022/6/20 23:43
 * @description
 */
public class Solution {

    /**
     * 比特位计算
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
     * 计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     * 示例：
     * 输入：n = 2
     * 输出：[0,1,1]
     * 解释：
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     */
    public int[] countBits(int n) {
        // 0-n的数组长度为n+1
        int[] nums = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nums[i] = getBit(i);
        }
        return nums;
    }

    private int getBit(int num) {
        int count = 0;
        while (num > 0) {
            // 最末尾的1每次都被抵消掉，count+1
            num &= num - 1;
            count++;
        }
        return count;
    }

}
