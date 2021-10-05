package 读书笔记.数据结构By慕课网.数组.练习题.力扣;

/**
 * 283. 移动零
 * 题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 例子：输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
 */
public class LC283 {
    // 方法1：移动非0元素到左边
    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, j, i);
                j++;
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 方法1:优化
    public void moveZeroes1_1(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // i>j避免数组开头是非零元素的交换，阻止（i==j）时交换
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    // 方法2:两次遍历
    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        // 一次遍历，非0元素，前移到数组前面，用j记录
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        // 二次遍历，从j开始赋值0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
