package 剑指Offer.第二版.第2章_面试需要的基础知识.q03_数组中重复的数字;


public class Solution {
    /**
     * 题目：nums长度为n，数字为0到n-1，有些数字重复了，找出任意重复的一个数字
     */
    public int findRepeatNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            // 数字范围为0到n-1,重排后，数字i应该放在下标为i的位置上
            // 如果数字i已经放在下标为i的位置上，说明这个下标是第一个遇到该数字，跳过本次循坏
            if (nums[index] == index) {
                index++;
                continue;
            }
            // 当元素值和坐标不对应
            // 情况1：第二次来到该位置，就是重复元素
            if (nums[index] == nums[nums[index]]) {
                return nums[index];
            } else {// 情况2：两者还不对应，说明要将数字归位到第一次出现的下标位置上
                int temp = nums[index];
                nums[index] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.findRepeatNumber(nums));
    }

}
