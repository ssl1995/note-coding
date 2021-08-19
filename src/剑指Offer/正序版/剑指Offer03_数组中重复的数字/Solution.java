package 剑指Offer.正序版.剑指Offer03_数组中重复的数字;


public class Solution {
    // 题目：nums长度为n，数字为0到n-1，有些数字重复了，找出任意重复的一个数字
    // 方法:数组下标与元素对应
    public int findRepeatNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            // 元素值和坐标对应，遍历指针后移+进行下次循环
            if (nums[index] == index) {
                index++;
                continue;
            }
            // 当元素值和坐标不对应
            // 情况1：第二次来到该位置，就是重复元素
            if (nums[index] == nums[nums[index]]) {
                return nums[index];
            } else {// 情况2：归位，让其归位到第一次出现的位置
                int temp = nums[index];
                nums[index] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }

}
