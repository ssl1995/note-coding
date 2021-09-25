package 慕课网数据结构.数组.练习题.力扣;

/**
 * 27. 移除元素
 * 题目：给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 例子：给定 nums = [3,2,2,3], val = 3,函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 */
public class LC27 {
    // 方法1:j保存不是val的索引，i遍历数组
    public int removeElement1(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // 方法1优化:避免val在开头，或者在结尾，出现过多的重复复制操作
    public int removeElement1_1(int[] nums, int val) {
        int i = 0;
        // n是数组长度=末尾索引+1
        int n = nums.length;
        while (i < n) {
            // 等于就和最后一个元素交换
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            }else{
                i++;
            }
        }
        return n;
    }
}
