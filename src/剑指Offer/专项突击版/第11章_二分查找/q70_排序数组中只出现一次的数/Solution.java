package 剑指Offer.专项突击版.第11章_二分查找.q70_排序数组中只出现一次的数;

/**
 * @author SongShengLin
 * @date 2021/10/24 10:34 上午
 * @description
 */
public class Solution {
    // 在【排序】数组中查找出现一次的数，就可以不用异或
    public int singleNonDuplicate(int[] nums) {
        // 将数组分为0-len/2组，也就是两两为一组
        int left = 0;
        int right = nums.length / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 两两为一组的数组内，第一个数下标
            int firstIndex = mid * 2;
            if (firstIndex < nums.length - 1 && nums[firstIndex] != nums[firstIndex + 1]) {

                if (firstIndex == 0 || nums[firstIndex - 1] == nums[firstIndex - 2]) {
                    return nums[firstIndex];
                }
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        // 奇数情况下，两两一组没找到，说明出现一次的数在数组最后一位
        return nums[nums.length - 1];

    }
}
