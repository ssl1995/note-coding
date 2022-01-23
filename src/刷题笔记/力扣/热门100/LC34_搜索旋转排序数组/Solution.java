package 刷题笔记.力扣.热门100.LC34_搜索旋转排序数组;

/**
 * @author SongShengLin
 * @date 2022/1/23 9:52 PM
 * @description
 */
public class Solution {

    /**
     * 搜索旋转排序数组
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 等于就返回
            if (nums[mid] == target) {
                return mid;
            }
            // 左边有序，在左边寻找
            if (nums[0] <= nums[mid]) {
                // [0]边界是等于
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // [n-1]边界是等于
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(solution.search(nums, target));
    }
}
