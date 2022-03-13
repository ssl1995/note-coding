package 刷题笔记.力扣.热门100.LC31_下一个排列;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/1/21 8:58 AM
 * @description
 */
public class Solution {
    /**
     * 下一个排列
     * 输入：nums = [4,5,2,6,3,1]
     * 变化：nums->[4,5,3,6,2,1]
     * 变化：nums->[4,5,3,1,2,6]
     * 输出：[4,5,3,1,2,6]
     */
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        // 从后往前跳过降序，找到i位置使得nums[i]<nums[i+1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果i>=0存在，往后找第一个比它大的数交换
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 逆置[i+1,n-1]的数，保证最靠近是最靠近原始数组的下一个排列数
        reverseAfterI(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseAfterI(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 2, 6, 3, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
