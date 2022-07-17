package 刷题笔记.力扣.热门100.LC55_跳跃游戏;

/**
 * @author SongShengLin
 * @date 2022/1/26 8:58 AM
 * @description
 */
public class Solution {
    /**
     * 跳跃游戏
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        int n = nums.length;
        int maxR = 0;
        // 1.从左到右，记录能到达的最右位置
        for (int i = 0; i < n; i++) {
            // 2.如果最右位置到达不了当前的i位置，永远无法到到n-1位置，返回false
            if (i > maxR) {
                return false;
            }

            maxR = Math.max(maxR, i + nums[i]);
            // 3.反之，返回true
            if (maxR >= n - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums));
    }
}
