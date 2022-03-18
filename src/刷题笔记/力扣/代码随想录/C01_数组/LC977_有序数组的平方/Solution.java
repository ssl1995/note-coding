package 刷题笔记.力扣.代码随想录.C01_数组.LC977_有序数组的平方;

/**
 * @author SongShengLin
 * @date 2021/10/13 9:29 上午
 * @description
 */
public class Solution {
    /**
     * 有序数组的平方
     * 示例 1： 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
     */
    public int[] sortedSquares(int[] nums) {
        // 有序数组，提示用双指针
        int left = 0;
        int right = nums.length - 1;

        // 从后往前遍历结果数组
        int[] res = new int[nums.length];
        int index = nums.length - 1;

        while (left <= right) {
            // 原数组的双指针，谁平方大就移动谁
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                res[index--] = nums[right] * nums[right];
                right--;
            } else {
                res[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }
}
