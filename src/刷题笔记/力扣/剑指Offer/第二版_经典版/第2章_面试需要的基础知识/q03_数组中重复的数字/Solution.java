package 刷题笔记.力扣.剑指Offer.第二版_经典版.第2章_面试需要的基础知识.q03_数组中重复的数字;


public class Solution {
    /**
     * 题目：nums长度为n，数字为0到n-1，有些数字重复了，找出任意重复的一个数字
     */
    public int findRepeatNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            // 数字范围为0到n-1,重排后，数字i应该放在下标为i的位置上
            // 0下标放元素0，不是重复元素，跳过本次循环，移动指针
            if (nums[index] == index) {
                index++;
                continue;
            }
            // x下标没有元素x
            // 如果元素x等于对应的x下标上元素，就是重复元素，返回
            if (nums[index] == nums[nums[index]]) {
                return nums[index];
            } else {// 否则，交换元素x来到它对应的x下标位置
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
