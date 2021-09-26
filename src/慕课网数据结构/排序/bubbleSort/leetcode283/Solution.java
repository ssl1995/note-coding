package 慕课网数据结构.排序.bubbleSort.leetcode283;

public class Solution {

    public void moveZeroes(int[] nums) {
        int index = 0;
        // 1.非0元素往前放,index记录放的位置
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        // 2.[index,n-1]放回0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
