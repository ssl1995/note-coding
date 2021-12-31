package 学习笔记.剑指Offer.专项突击版.第13章_回溯法.q81_允许重复选择元素的组合;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/10 9:40 上午
 * @description
 */
public class Solution {
    // 输入没有重复的数字，同一个数字可以在组合中重复出现
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> com = new LinkedList<>();
        helper(candidates, target, 0, com, res);
        return res;
    }

    private void helper(int[] nums, int target, int index, LinkedList<Integer> com, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(com));
        } else if (target > 0 && index < nums.length) {
            // 选择1：没有选择当前数字，下标+1递归
            helper(nums, target, index + 1, com, res);

            // 选择2：选择当前数字
            com.add(nums[index]);
            // 输出可以使用重复数字，所以index不用+1
            helper(nums, target - nums[index], index, com, res);
            // 回到父节点时，清除子集状态
            com.removeLast();
        }
    }
}
