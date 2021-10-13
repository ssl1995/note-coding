package 力扣.c01_数组.LC704_二分查找;

/**
 * @author SongShengLin
 * @date 2021/10/13 9:09 上午
 * @description
 */
public class Solution1 {
    /**
     * 二分查找条件：
     * 1.数组升序
     * 2.数组元素无重复值
     */

    // 版本2：[left,right)
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        // 右边为开区间
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 右边为开区间，右指针每次都指向边界，不用-1
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
