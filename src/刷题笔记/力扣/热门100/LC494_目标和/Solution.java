package 刷题笔记.力扣.热门100.LC494_目标和;

/**
 * @author SongShengLin
 * @date 2022/2/27 10:03 PM
 * @description
 */
public class Solution {

    private int res;

    /**
     * 目标和
     * 向数组中的每个整数前添加 '+' 或 '-'，构成不同表达式的数量
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     */
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        res = 0;
        dfs(nums, target, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int t, int index, int sum) {
        if (index == nums.length) {
            if (sum == t) {
                res++;
            }
        } else {
            dfs(nums, t, index + 1, sum + nums[index]);
            dfs(nums, t, index + 1, sum - nums[index]);
        }
    }
}
