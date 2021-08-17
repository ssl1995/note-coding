package 牛客.NC102_二分查找II;

public class Solution {

    // NC102:二分变种，数组升序有重复值，查找第一个等于给定值的坐标

    // 优化写法
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {// >=就缩小右指针
                right = mid - 1;
            }
        }
        // 循环跳出，左指针来到第一个target位置没越界且等于target，就返回mid
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    // 傻瓜写法
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
