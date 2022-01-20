package 刷题笔记.力扣.编号刷题.LC977_有序数组的平方;

/**
 * @author SongShengLin
 * @date 2021/10/13 9:29 上午
 * @description
 */
public class Solution {
    // 非递减数组，每个元素平方后，同样形成一个非递减的新数组
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] res = new int[nums.length];
        // 从后往前遍历结果数组
        int index = nums.length - 1;

        while (left <= right) {
            // 原数组的双指针，谁被用到了，就移动谁
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
