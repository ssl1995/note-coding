package 力扣.刷题.LC27_移除元素;

/**
 * @author SongShengLin
 * @date 2021/10/13 9:22 上午
 * @description
 */
public class Solution {
    // 原地删除数组中重复的val值
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            // 双指针，快指针遇到!=val的，就让慢指针赋值，慢指针后移
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            // 每一次循环，快指针都要后移
            fast++;
        }
        return slow;
    }
}
