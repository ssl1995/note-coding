package 刷题笔记.力扣.热门100.LC34_在排序数组中查找第一个和最后一个位置;

/**
 * @author SongShengLin
 * @date 2021/12/26 6:15 PM
 * @description
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (!isContainTarget(nums, target)) {
            return new int[]{-1, -1};
        }
        return new int[]{getNextTargetFirstIndex(nums, target - 1), getNextTargetFirstIndex(nums, target) - 1};
    }

    private boolean isContainTarget(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    private int getNextTargetFirstIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 经验:二分法中<=就是返回t的右边界
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // left <= right打破的时候，left来到>target的第一个数的下标
        return left;
    }
}
