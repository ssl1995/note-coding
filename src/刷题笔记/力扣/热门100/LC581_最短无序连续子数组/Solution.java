package 刷题笔记.力扣.热门100.LC581_最短无序连续子数组;

/**
 * @author SongShengLin
 * @date 2022/2/27 11:43 AM
 * @description
 */
public class Solution {

    /**
     * 最短无序连续子数组
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        // 将原数组分为[左边有序，中间无需，右边有序]
        // 中间无需特性：中间最小值>左边最大值 中间最大值<右边最小值

        int min = nums[n - 1];
        int max = nums[0];

        // 进入左段之前，left就是最后一个>min的位置
        int left = 0;

        // 进入右段之前，right就是最后一个<max的位置
        // 注意初始化right为-1，因为长度差一开始不存在
        int right = -1;

        for (int i = 0; i < n; i++) {
            // 中间无需特性：中间最小值>左边最大值 中间最大值<右边最小值

            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }

            if (nums[n - 1 - i] > min) {
                left = n - i - 1;
            } else {
                min = nums[n - 1 - i];
            }

        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}
