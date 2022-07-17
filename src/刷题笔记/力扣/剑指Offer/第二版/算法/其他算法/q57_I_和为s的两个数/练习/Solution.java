package 刷题笔记.力扣.剑指Offer.第二版.算法.其他算法.q57_I_和为s的两个数.练习;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/1/16 7:37 PM
 * @description
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int t = nums[left] + nums[right];
            if (t < target) {
                left++;
            } else if (t > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
