package 刷题笔记.力扣.热门100.LC136_只出现一次的数字;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/16 9:45 AM
 * @Describe:
 */
public class Solution {

    /**
     * 只出现一次的数字
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            // 数组中出现2次的都异或彼此，然后=0
            // 异或：0^x=x;x^x=0
            single ^= num;
        }
        return single;
    }
}
