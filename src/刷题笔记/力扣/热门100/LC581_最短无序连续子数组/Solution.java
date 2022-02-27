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
        int min = nums[n - 1];
        int max = nums[0];

        // 注意初始化right为-1，因为长度差一开始不存在
        int left = 0;
        int right = -1;

        for (int i = 0; i < n; i++) {
            // 中间段特性：虽然无序，但其中最大值<右段最小值,最大值>左段最大值
            // right：从左到右记录max，保存进入右段之前最后一个<max的数
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }
            // left:从右往左记录min，保存进入左段之前最后一个>min的数
            if (nums[n - i - 1] <= min) {
                min = nums[n - i - 1];
            } else {
                left = n - i - 1;
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
