package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第11章_二分查找.q68_查找插入位置;

/**
 * @author SongShengLin
 * @date 2021/10/24 10:04 上午
 * @description
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 存在，前一个也<t且当前数=t,就返回本身；不存在，前一个数<t且当前数>t
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 0和数组中存在的位置都扫描过，就返回数组长度
        return nums.length;
    }
}
