package 刷题笔记.力扣.编号刷题.LC704_二分查找;

/**
 * @author SongShengLin
 * @date 2021/10/13 9:09 上午
 * @description
 */
public class Solution {
    /**
     * 二分查找条件：
     * 1.数组升序
     * 2.数组元素无重复值
     */

    // 版本1：[left,right]
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
