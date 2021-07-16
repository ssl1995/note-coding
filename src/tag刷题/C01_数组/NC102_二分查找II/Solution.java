package tag刷题.C01_数组.NC102_二分查找II;

public class Solution {
    // 标准二分
    public int search0(int[] nums, int target) {
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

    // NC102:二分变种1，数组升序有重复值，查找第一个等于给定值的坐标
    // 最容易理解的写法
    public int search(int[] nums, int target) {
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

    // 二分变种1:优化后的写法，强烈不推荐这么写，因为很难记
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
        } else {
            return -1;
        }
    }


    // 二分变种2:数组升序有重复值，查找最后一个值等于给定值的坐标
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
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    // 二分变种3:数组升序有重复值，查找第一个>=给定值的下标
    public int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // 二分变种4:数组升序有重复值，查找最后一个<=给定值的下标
    public int search4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] <= target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
