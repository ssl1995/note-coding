package 刷题笔记.力扣.热门100.LC34_在排序数组中查找第一个和最后一个位置;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/1/15 12:10 PM
 * @description
 */
public class Solution1 {

    /**
     * 在排序数组中查找第一个和最后一个位置
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{binarySort1(nums, target), binarySort2(nums, target)};
    }

    /**
     * 返回>=t的第一个下标
     */
    private int binarySort1(int[] nums, int t) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < t) {
                left++;
            } else if (nums[mid] > t) {
                right--;
            } else {
                if (mid == 0 || nums[mid - 1] < t) {
                    return mid;
                }
                right--;
            }
        }
        return -1;
    }

    /**
     * 返回<=t的第一个下标
     */
    private int binarySort2(int[] nums, int t) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < t) {
                left++;
            } else if (nums[mid] > t) {
                right--;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > t) {
                    return mid;
                }
                left++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int t = 8;
        System.out.println(Arrays.toString(solution.searchRange(nums, 8)));
    }
}
