package 读书笔记.数据结构By慕课网.排序.quickSort.练习题;


public class LC75 {
    // 方法1：使用三路快排
    public void sortColors1(int[] nums) {
        int l = -1, i = 0, r = nums.length;
        while (i < r) {
            if (nums[i] < 1) {
                l++;
                swap(nums, i, l);
                i++;
            } else if (nums[i] > 1) {
                r--;
                swap(nums, i, r);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
