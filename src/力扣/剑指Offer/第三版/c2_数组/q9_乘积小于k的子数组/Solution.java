package 力扣.剑指Offer.第三版.c2_数组.q9_乘积小于k的子数组;

/**
 * @author SongShengLin
 * @date 2021/9/14 9:24 上午
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;// left、right初始化指向数组第一位
        long product = 1;// 乘积值
        int count = 0;// 统计次数
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            // 判断是否需要右移left：product>=k
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            // 统计次数
            count += right >= left ? right - left + 1 : 0;
        }
        return count;
    }
}
