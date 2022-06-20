package 刷题笔记.力扣.热门100.LC283_移动零;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/20 9:17 AM
 * @Describe:
 */
public class Solution {

    /**
     * 移动零
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        // 快速排序，<0的放左边，>0的放右边
        // j保存最左边最后一个元素的位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
