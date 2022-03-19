package 刷题笔记.力扣.代码随想录.C01_数组.LC209_长度最小的子数组;

/**
 * @author SongShengLin
 * @date 2022/3/19 00:15
 * @description
 */
public class Solution {

    /**
     * LC209_长度最小的子数组
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        while (j <= nums.length - 1) {
            sum += nums[j];
            // 滑动窗口
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
            // 上面跑完，才后移j++
            j++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
