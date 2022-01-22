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
     * 输入：nums = [1,2,3,4,6,5]
     * 输出：[1,2,3,5,6,4]
     */
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        // 从后往前找升序
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // (i,len-1]找比nums[i]大的第一个数
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 逆置[j,end),使i后面的数升序
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
        int[] nums = {1, 2, 3, 4, 6, 5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
