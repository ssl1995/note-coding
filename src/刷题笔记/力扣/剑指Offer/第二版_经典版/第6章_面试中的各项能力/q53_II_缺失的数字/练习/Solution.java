package 刷题笔记.力扣.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q53_II_缺失的数字.练习;

/**
 * @author SongShengLin
 * @date 2022/1/16 2:52 PM
 * @description
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (left == nums.length) {
            return nums.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3};
        System.out.println(solution.missingNumber(arr));
    }
}
