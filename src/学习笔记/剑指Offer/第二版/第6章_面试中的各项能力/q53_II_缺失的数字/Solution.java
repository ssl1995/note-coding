package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q53_II_缺失的数字;

/**
 * @author SongShengLin
 * @date 2021/12/27 8:40 AM
 * @description
 */
public class Solution {
    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     */
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 中间元素值与下标相等，下一轮查找在右边
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                // 中间元素与下标不相等
                // mid==0 或 中间前一个元素与下标相等，mid就是缺失数字
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
                // 中间元素前一个元素与下标不相等，下一轮遍历左边
                right = mid - 1;
            }
        }
        // left来到数组长度位置，说明长度n-1全部匹配，[0,1,2]，返回数组长度
        if (left == nums.length) {
            return nums.length;
        }
        // 无效的输入，返回-1
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(solution.missingNumber(arr));
    }
}
