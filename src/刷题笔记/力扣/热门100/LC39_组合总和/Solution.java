package 刷题笔记.力扣.热门100.LC39_组合总和;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/1/23 10:15 PM
 * @description
 */
public class Solution {
    /**
     * 组合总和：candidates无重复元素，但同一个数字可以重复使用
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        process(candidates, target, 0, temp, res);
        return res;
    }

    private void process(int[] nums, int target, int i, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(temp));
        } else if (i <= nums.length - 1 && target > 0) {
            // 跳过i位置
            process(nums, target, i + 1, temp, res);

            // 选择i位置加入
            // 条件无限制重复：重复访问i位置
            temp.add(nums[i]);
            process(nums, target - nums[i], i, temp, res);
            // i位置访问完毕，回溯返回之前状态
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 5};
        int target = 8;
        System.out.println(solution.combinationSum(nums, target));
    }

}
