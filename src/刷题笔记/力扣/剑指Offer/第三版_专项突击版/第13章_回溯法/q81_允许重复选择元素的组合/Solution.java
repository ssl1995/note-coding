package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第13章_回溯法.q81_允许重复选择元素的组合;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/10 9:40 上午
 * @description
 */
public class Solution {
    /**
     * 给定一个没有重复数字的正整数集合，找出所有元素之和等于t的所有组合
     * 示例：can=[2,3,5],t=8,结果为[2,2,2,2],[2,3,3],[3,5]
     */
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
