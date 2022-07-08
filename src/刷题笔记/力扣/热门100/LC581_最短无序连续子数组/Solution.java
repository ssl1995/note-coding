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
        // 将原数组分为[左边有序，中间无需，右边有序]
        int n = nums.length;

        // 从右往左，找中间无序左边界
        int left = 0;
        int min = nums[n - 1];

        // 从左往右，找中间无序右边界
        int right = 0;
        int max = nums[0];

        for (int i = 0; i < n; i++) {
            // 进入右边有序部分前，中间右边界就是<max最后一个数的坐标
            if (nums[i] < max) {
                right = i;
            } else {
                // 否则只用更新max，进入右边有序后，max只会更新不影响right查找
                max = nums[i];
            }
            // 进入左边界前，中间有序左边界就是>min的最后一个数的坐标
            if (nums[n - 1 - i] > min) {
                left = n - i - 1;
            } else {
                // 否则只用更新min，进入左边有序后，min只会更新不影响left查找
                min = nums[n - 1 - i];
            }

        }
        // 没有找到，中间无序长度为0
        if (left == 0 && right == 0) {
            return 0;
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}
