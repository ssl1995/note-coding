package 刷题笔记.力扣.热门100.LC152_乘积最大子数组;

/**
 * @author SongShengLin
 * @date 2022/3/2 8:56 AM
 * @description
 */
public class Solution {

    /**
     * 乘积最大子数组
     * 注意：子数组指数组的连续子序列
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        // 由于存在负数,导致子数组乘积从最大变成最小
        // 所以每一位数组元素都需要存当前位置的最大乘积、最小乘积
        // iMax:表示0到i的最大乘积
        int iMax = 1;
        // iMin:表示0到i的最小乘积
        int iMin = 1;
        for (int num : nums) {
            // 遇到负数，交换iMax、iMin
            if (num < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }

            iMax = Math.max(iMax * num, num);
            iMin = Math.min(iMin * num, num);

            max = Math.max(max, iMax);
        }
        return max;
    }

}
