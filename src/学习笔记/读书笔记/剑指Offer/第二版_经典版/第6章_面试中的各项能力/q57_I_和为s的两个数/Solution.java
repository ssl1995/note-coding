package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q57_I_和为s的两个数;

public class Solution {

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
     * 如果有多对数字的和等于s，则输出任意一对即可。
     */
    public int[] twoSum(int[] nums, int target) {
        // 因为数组有序，首尾确定两个数
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // 小了，就移动左指针
            if (sum < target) {
                left++;
            } else if (sum > target) {
                // 大了，就移动右指针
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }
}