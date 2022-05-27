package 刷题笔记.力扣.剑指Offer.第二版_经典版.第3章_高质量代码.q21_调整数组奇数位于偶数前面;


public class Solution {

    /**
     * 力扣：使用双指针法，相对次序会发生改变
     */
    public int[] exchange(int[] nums) {
        // 定义两个指针，一个指向数组第一个元素，一个指向最后一个元素
        int left = 0;
        int right = nums.length - 1;
        // 最中间的位置左右指针一旦越过,就又交换回去了,所以是left<right
        while (left < right) {
            // 循环里面嵌套循环,需要再次判断left<right
            // 左指针越过奇数，找偶数
            while (left < right && (nums[left] & 1) != 0) {
                left++;
            }
            // 右指针越过偶数，找奇数
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            // 交换
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
